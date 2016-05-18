package com.healpal.job

import com.healpal.care.PatientMatchService;
class PatientMatchJob {
	 def PatientMatchService;
    static triggers = {
      simple repeatInterval: 2000 // execute job once in 5 seconds
    }

    def execute() {
        // execute job
		PatientMatchService.doBatchProcess();
    }
}
