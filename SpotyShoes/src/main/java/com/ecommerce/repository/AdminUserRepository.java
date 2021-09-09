package com.ecommerce.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.AdminUser;

public interface AdminUserRepository extends CrudRepository<AdminUser, Integer>{
	
	@Query(value = "SELECT * FROM admin WHERE admin_username = :username", nativeQuery = true)
	public List<AdminUser> getAdminUserByUsername(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE admin SET admin_password = :newPassword WHERE admin_username = :username", nativeQuery = true)
	public int changeUserPassword(@Param("username") String username, @Param("newPassword") String newPassword);
}
