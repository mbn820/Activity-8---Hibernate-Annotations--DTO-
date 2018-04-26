package com.exist.ecc.app.forms;

import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.service.RoleService;
import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.dto.*;

public class AddRolesForm {

	public static void show() {
		RoleDto role = PersonDetailsInput.getSingleRoleInformation();

		ConsoleInputUtil.getAll("Press Enter to continue.......");

		if(new RoleService().roleAlreadyExists(role)) {
			System.out.println("Role already exists");
			addMoreRoleOrProceed();
			return;
		}

		new RoleService().addRole(role);
		System.out.println("Role Added");

		addMoreRoleOrProceed();

	}

	public static void addMoreRoleOrProceed() {
		String choice = ConsoleInputUtil.getDesiredString("Add more role or proceed? [a/p]: ", "a", "p");

		switch(choice) {
			case "a" : show(); break;
			case "p" : break;
		}
	}
}
