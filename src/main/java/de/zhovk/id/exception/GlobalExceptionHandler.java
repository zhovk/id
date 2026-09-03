package de.zhovk.id.exception;

import de.zhovk.id.common.entity.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiResponse<Void>> handleNotFound(NotFoundException ex) {
    return ResponseEntity.status(404).body(ApiResponse.error("Not Found", ex.getMessage(), 404));
  }
}
