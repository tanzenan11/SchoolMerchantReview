package com.cmr.service;

import com.cmr.dto.Result;
import com.cmr.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *
 * </p>
 *
 * @author 谭泽楠
 * @since 2024-8-4
 */
public interface IShopService extends IService<Shop> {


    Result queryById(Long id);

    Result update(Shop shop);
}
