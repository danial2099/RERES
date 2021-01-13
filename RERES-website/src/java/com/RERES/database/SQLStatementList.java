/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RERES.database;

public interface SQLStatementList {
    // List of SELECT instruction
    String SQL_STATEMENT_RETRIEVE_ALL_USERS_INFORMATION = "SELECT * FROM User;";
    String SQL_STATEMENT_RETRIEVE_ALL_SPECIFIC_USER_INFORMATION = "SELECT * FROM User WHERE user_type=?;";
    String SQL_STATEMENT_RETRIEVE_ALL_BOOKING_WITH_PAYMENT_ORDER_AND_CUSTOMER_NAME_INFORMATION_BY_BOOKING_ID = "SELECT " +
        "   `payment`.`payment_id`, `payment`.`payment_status`, `payment`.`payment_method`, `payment`.`total_payment`, `payment`.`date_paid`, `payment`.`fk_bookingID`, " +
        "   `booking`.`booking_description`, `booking`.`booking_date`, `booking`.`booking_duration`, `booking`.`booking_start_time`, `booking`.`booking_end_time`, `booking`.`booking_status`, `booking`.`booking_quantity`, `booking`.`booking_price`, `booking`.`booking_date_created`, `booking`.`fk_userID`, " +
        "   `user`.`name`, " +
        "   `orderitem`.`order_item_id`, `orderitem`.`item_quantity`, `orderitem`.`total_price` " +
        "FROM `payment` " +
        "INNER JOIN `booking` ON `payment`.`fk_bookingID` = `booking`.`booking_id` AND `booking`.`booking_id` = ? " +
        "INNER JOIN `user` ON `booking`.`fk_userID` = `user`.`user_id` AND `user`.`user_type`=\"customer\" " +
        "INNER JOIN `orderitem` ON `payment`.`fk_bookingID` = `orderitem`.`fk_bookingID` AND `orderitem`.`fk_bookingID` = ?;";
    String SQL_STATEMENT_RETRIEVE_ALL_BOOKING_INFORMATION = "SELECT * FROM `booking`;";
    
    // List of INSERT instruction
    
    // List of UPDATE instruction
    String SQL_STATEMENT_UPDATE_A_USER_INFORMATION = "UPDATE `user` SET `name`=?,`age`=?,`birth_date`=?,`email`=?,`address`=?,`gender`=?,`phone_number`=?,`profile_photo`=? WHERE `user`.`user_id`=?;";
    
    // List of DELETE instruction
    String SQL_STATEMENT_DELETE_A_USER_INFORMATION = "DELETE FROM `user` WHERE `user`.`user_id` = ?;";
}
