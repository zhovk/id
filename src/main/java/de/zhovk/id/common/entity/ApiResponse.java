package de.zhovk.id.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

  private boolean success;
  private String message;
  private T data;
  private List<String> errors;
  private Integer errorCode;

  @Builder.Default private LocalDateTime timestamp = LocalDateTime.now();

  private String path;

  public static <T> ApiResponse<T> success(T data) {
    return success(data, null, null);
  }

  public static <T> ApiResponse<T> success(T data, String message) {
    return success(data, message, null);
  }

  public static <T> ApiResponse<T> success(T data, String message, String path) {
    return ApiResponse.<T>builder().success(true).message(message).data(data).path(path).build();
  }

  public static <T> ApiResponse<T> error(String error, String message, Integer errorCode) {
    return error(List.of(error), message, errorCode, null);
  }

  public static <T> ApiResponse<T> error(
      String error, String message, Integer errorCode, String path) {
    return error(List.of(error), message, errorCode, path);
  }

  public static <T> ApiResponse<T> error(List<String> errors, String message, Integer errorCode) {
    return error(errors, message, errorCode, null);
  }

  public static <T> ApiResponse<T> error(
      List<String> errors, String message, Integer errorCode, String path) {
    return ApiResponse.<T>builder()
        .success(false)
        .message(message)
        .errors(errors)
        .errorCode(errorCode)
        .path(path)
        .build();
  }
}
