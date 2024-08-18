package com.cmr.service.impl;

import cn.hutool.json.JSONUtil;
import com.cmr.dto.Result;
import com.cmr.entity.ShopType;
import com.cmr.mapper.ShopTypeMapper;
import com.cmr.service.IShopTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static com.cmr.utils.RedisConstants.CATEGORY_SHOP_KEY;

/**
 * <p>
 *
 * </p>
 *
 * @author 谭泽楠
 * @since 2024-8-4
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private IShopTypeService shopTypeService;

    @Override
    public Result category() {
        // 1.查询redis分类缓存
        List<String> list = stringRedisTemplate.opsForList().range(CATEGORY_SHOP_KEY, 0, -1);

        // 2.判断是否存在
        if (list.size() != 0) {
            List<ShopType> shopCategory = new ArrayList<>();
            list.forEach(item -> {
                shopCategory.add(JSONUtil.toBean(item, ShopType.class));
            });
            return Result.ok(shopCategory);
        }
        // 4.不存在，根据id查询数据库
        List<ShopType> shopCategory = shopTypeService.query().orderByAsc("sort").list();
        // 5.不存在，直接返回错误
        if (shopCategory.size() == 0) {
            return Result.fail("店铺类别错误！");
        }
        // 6.存在，将数据写入redis
        shopCategory.forEach(category -> stringRedisTemplate.opsForList().rightPush(CATEGORY_SHOP_KEY, JSONUtil.toJsonStr(category)));
        // 7.返回数据
        return Result.ok(shopCategory);
    }
}
