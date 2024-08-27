package com.joaovtmarques.ecommerce.data.dto;

import java.util.List;

public record AddOrderDTO(List<Long> productsId, Long customerId) {

}
