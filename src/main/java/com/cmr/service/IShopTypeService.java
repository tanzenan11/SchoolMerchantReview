package com.cmr.service;

import com.cmr.dto.Result;
import com.cmr.entity.ShopType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *
 * </p>
 *
 * @author 谭泽楠
 * @since 2024-8-4
 */
public interface IShopTypeService extends IService<ShopType> {

    Result category();
}
