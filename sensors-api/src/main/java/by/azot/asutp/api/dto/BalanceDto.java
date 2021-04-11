package by.azot.asutp.api.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BalanceDto {

    private Long id;
    private String name;
    private Date dateBegin;
    private Date dateEnd;
    private Long modifiedByUser;
    private Date dateModified;

    //    private UserDto user;
}
