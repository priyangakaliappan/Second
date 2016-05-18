
            jQuery(document).ready(function ($) {
                $('#banner-fade').bjqs({
                    height: 428,
                    width: 670,
                    responsive: true,
                    automatic : false,
                    showcontrols : true
                    //showmarkers : true 
                    //loopRewind: true
                });
                
                
                $('#banner-fade1').bjqs({
                    height: 428,
                    width: 670,
                    responsive: true,
                    automatic : false
                });
                
                $('.secret-source').secretSource({
                    includeTag: false
                });
                
                
            });

            
        