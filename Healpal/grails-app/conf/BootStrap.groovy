import com.healpal.authentication.BootInsertService
import com.healpal.care.HealpalUser
import com.healpal.care.Role
import com.healpal.care.RoleService
import com.healpal.care.UserRole

class BootStrap {

	def BootInsertService bootInsertService
	
    def init = { servletContext ->
		bootInsertService . bootSave()
		bootInsertService . bootUserSave()
    }
    def destroy = {
    }
}
