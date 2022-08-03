package com.nvclouds.medusaskadicommon.exception;

import com.nvclouds.medusaskadicommon.enums.GlobalEnums;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private GlobalEnums globalEnums;
}
