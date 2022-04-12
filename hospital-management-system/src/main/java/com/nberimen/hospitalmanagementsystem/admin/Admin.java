
package com.nberimen.hospitalmanagementsystem.admin;

import com.nberimen.hospitalmanagementsystem.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADMIN")
@Data
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Admin extends User {

}
