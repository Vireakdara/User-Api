package com.example.demo.rest.response;

public class Messages {

    public enum Success {
        INSERT_SUCCESS("Record has been inserted successfully");
        private String message;

        Success(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }


    }
}
