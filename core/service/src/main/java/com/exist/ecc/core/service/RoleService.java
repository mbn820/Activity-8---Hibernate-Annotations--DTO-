package com.exist.ecc.core.service;

import com.exist.ecc.core.dao.RoleDao;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.model.dto.RoleDto;
import java.util.List;

public class RoleService {
	public Integer addRole(RoleDto roleDto) {
		Role roleToBeAdded = new MapperUtil().mapToRole(roleDto);
		return new RoleDao().addRole(roleToBeAdded);
	}

	public RoleDto getRole(int id) {
		Role role = new RoleDao().getRole(id);
		return new MapperUtil().mapToRoleDto(role);
	}

	public List<RoleDto> getAllRoles() {
		List<Role> roles = new RoleDao().getAllRoles();
		return new MapperUtil().mapToRoleDtoList(roles);
	}

	public void updateRole(RoleDto role) {
		Role roleToBeUpdated = new MapperUtil().mapToRole(role);
		new RoleDao().updateRole(roleToBeUpdated);
	}

	public void deleteRole(int id) throws Exception {
		if( !getRole(id).getPersons().isEmpty() ) {
			throw new Exception();
		} else {
			new RoleDao().deleteRole(id);
		}
	}

	public boolean roleAlreadyExists(RoleDto role) {
		return getAllRoles().contains(role);
	}

	public void viewRoles() {
		System.out.printf("%-5s %-10s %s\n", "ID", "ROLE", "PERSONS");
		getAllRoles().forEach(role -> System.out.printf("%-5s %-10s %s\n", role.getId(), role.getRoleName(), role.getPersons()));
	}
}
