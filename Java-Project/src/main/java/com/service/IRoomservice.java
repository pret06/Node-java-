package com.service;

import java.math.BigDecimal;
import org.springframework.web.multipart.MultipartFile;
import com.model.Room;

public interface IRoomservice {
    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice);
}
