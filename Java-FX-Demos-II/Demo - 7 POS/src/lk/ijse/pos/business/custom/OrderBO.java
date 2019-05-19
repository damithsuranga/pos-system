package lk.ijse.pos.business.custom;

import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.OrderDTO;

public interface OrderBO extends SuperBO {

    public boolean placeOrder(OrderDTO order);

    public int generateOrderId() throws Exception;

}
