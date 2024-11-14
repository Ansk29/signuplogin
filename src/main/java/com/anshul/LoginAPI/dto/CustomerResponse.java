package com.anshul.LoginAPI.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
public record CustomerResponse (
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("email")
        String email
)
{
}