package dev.patika.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryUpdateRequest {
    @Positive (message = "Id field must be positive")
    private int id;
    @NotNull (message = "Name field cannot be null")
    private String name;
}
