package com.exist.ecc.app.forms;

import com.exist.ecc.core.service.RoleService;
import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.util.Util;
import java.util.List;

public class DeleteRolesForm {
	public static void show() {
		List<Role> existingRoles = new RoleService().getAllRoles();
		Util.printRoleInfo(existingRoles);

		int chosenRoleId = ConsoleInputUtil.getAnyInteger("Enter the id of the role you want to delete: ");

		try {
			new RoleService().deleteRole(chosenRoleId);
			System.out.println("Role has been deleted");
		} catch(Exception e) {
			System.out.println("Cannot delete Role");
		}
	}
}
