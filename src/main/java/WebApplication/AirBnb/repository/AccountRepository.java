package WebApplication.AirBnb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebApplication.AirBnb.domain.Accounts;
import WebApplication.AirBnb.model.UserAccDto;
@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long>{
	@Query("SELECT u FROM Accounts u WHERE u.mail = :mail")
	Accounts getAccountByMail(@Param("mail") String mail);
	
	@Query("SELECT new WebApplication.AirBnb.model.UserAccDto(n.name , n.address , n.sex , n.dateOfBirth , "
			+ "n.CCCD , n.avatar , n.phoneNumber , t.accountId, t.mail, t.password, n.regisDate) from Accounts t join t.user n WHERE t.mail = :mail")
	UserAccDto getUserAccountByMail(@Param("mail") String mail);
	
	@Query("SELECT new WebApplication.AirBnb.model.UserAccDto(n.name , n.address , n.sex , n.dateOfBirth , "
			+ "n.CCCD , n.avatar , n.phoneNumber , t.accountId, t.mail, t.password, n.regisDate) from Accounts t join t.user n WHERE t.accountId = :accountId")
	UserAccDto getUserAccountByAccountId(@Param("accountId") long accountId);
	
	@Query(value="SELECT r FROM reset_password_token r WHERE r.reset_password_token = :reset_password_token",nativeQuery = true)
	Accounts findbyResetPasswordToken(@Param("reset_password_token") String token);
}

