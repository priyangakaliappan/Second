$(function(){

    //-----  FOR DEMO PURPOSES ONLY -----//
    //-----  FOR DEMO PURPOSES ONLY -----//
    //-----  FOR DEMO PURPOSES ONLY -----//

      // Update the notifications
      if($('.widget-notifications').length > 0){ 
        var listposition = 0;
        var i = 0;
        listposition = $('.widget-notifications ul li').length-1;
        var thetimer = setInterval(function() {
          i++;
            $('.widget-notifications ul').prepend('<li>'+$('.widget-notifications ul li').eq(listposition).html()+'</li>').css('height','0').slideDown();
          if(i >= 15){ clearInterval(thetimer); }
        }, 3500);
      }

      // Disable # function
      $('a[href="#"]').click(function(e){
        e.preventDefault();
      });

    //-----  / FOR DEMO PURPOSES ONLY -----//
    //-----  / FOR DEMO PURPOSES ONLY -----//
    //-----  / FOR DEMO PURPOSES ONLY -----//


    //-----  Menu functions -----//

    // if the page is rtl oriented
    if($('.navbar').css('right') == '0px' || $('.navbar').css('right') == '-225px'){
      // slide menu out from the right 
      $('.slide_menu_left').click(function(e){
          e.preventDefault();
          if($(".navbar").hasClass('open_left')){
            sidemenu_right_close();
          }else{
              sidemenu_right_open();
              $('.main_container').bind('click', function(){
                  sidemenu_right_close();
              });
          }
      });

    }else{

      // slide menu out from the left 
      $('.slide_menu_left').click(function(e){
          e.preventDefault();
          if($(".navbar").hasClass('open_left')){
            sidemenu_close();
          }else{
              sidemenu_open();
              $('.main_container').bind('click', function(){
                  sidemenu_close();
              });
          }
      });
    }

    // slide menu out
    function sidemenu_close(){
        $(".main_container").stop().animate({
            'left': '0'
        }, 250, 'swing');

        $(".navbar").stop().animate({
            'left': '-200px'
        }, 250, 'swing', function(){
            $(this).css('left', '').removeClass('open_left');
            $(this).children('.sidebar-nav').css('height', '');
        });

        $('.main_container').unbind('click');

        if(typeof handler != 'undefined'){
            $(window).unbind('resize', handler);
        }
    }

    // slide menu in
    function sidemenu_open(){
        $(".main_container").stop().animate({
            'left': '200px'
        }, 250, 'swing');
        $(".navbar").stop().animate({
            'left': '0'
        }, 250, 'swing').addClass('open_left');
        $('.navbar').animate('slow', function(){
            marginLeft:0
        });
    }

    // slide menu out
    function sidemenu_right_close(){
        $(".main_container").stop().animate({
            'right': '0'
        }, 250, 'swing');

        $(".navbar").stop().animate({
            'right': '-200px'
        }, 250, 'swing', function(){
            $(this).css('right', '').removeClass('open_left');
            $(this).children('.sidebar-nav').css('height', '');
        });

        $('.main_container').unbind('click');

        if(typeof handler != 'undefined'){
            $(window).unbind('resize', handler);
        }
    }

    // slide menu in
    function sidemenu_right_open(){
        $(".main_container").stop().animate({
            'right': '200px'
        }, 250, 'swing');
        $(".navbar").stop().animate({
            'right': '0'
        }, 250, 'swing').addClass('open_left');
        $('.navbar').animate('slow', function(){
            marginLeft:0
        });
    }

    $('.accordion-toggle').removeClass('toggled');
    // fade to white when clicked on mobile
    $('.accordion-toggle').click(function(){
      $('.accordion-toggle').removeClass('toggled');
      $(this).addClass('toggled');
    });

    //-----  Load RTL Styles -----//
    $('.loadrtl').click(function(e){
      e.preventDefault();
      loadcssfile('assets/css/style-rtl.css');
    })

    function loadcssfile(filename){
     
      var fileref=document.createElement("link")
      fileref.setAttribute("rel", "stylesheet")
      fileref.setAttribute("type", "text/css")
      fileref.setAttribute("href", filename)

     if (typeof fileref!="undefined")
      document.getElementsByTagName("head")[0].appendChild(fileref)
    }

    //-----  Notifications -----//

    //  Notifications on top ( Animate in on load )
    call_bluth_notification('undefined');
    $('.call_bluth_notification').click(function(e){
      e.preventDefault();
      call_bluth_notification($(this).data('message'));
    });

    function call_bluth_notification(msg){
      if($('#topmenu #alert').hasClass('isdown')){

        $('#topmenu #alert').animate({
          marginTop:'-50px'
        }, 300, 'swing', function(){
          if(msg != 'undefined'){
            $('#topmenu #alert p').html(msg);
          }
        });

      }else{
         if(msg != 'undefined'){
            $('#topmenu #alert p').html(msg);
         }
      }
        $('#topmenu #alert').addClass('isdown');

        $('#topmenu #alert').animate({
            marginTop:'-5px'
        }, 600, 'swing');
        $('#topmenu #alert .close').click(function(){
            $(this).parent().animate({
                marginTop:'-50px'
            }, 300, 'swing');
          $('#topmenu #alert').removeClass('isdown');
        });
    };

    //-----  Messages -----//

    if($('.widget-messages').length > 0){ // Make sure the messages widget is on the page
      $('.widget-messages .messagelist li').click(function(e){
        e.preventDefault();
        $(this).closest('.messagelist').children('li').removeClass('active');   // remove the active classes from everything
        $(this).addClass('active');                                             // and add it to the selected element
        $(this).closest('.widget-messages').find('h4.info').html('Conversation with '+$(this).data('name')+'<small>'+$(this).data('email')+'</small>'); // update the info tag with the name and the email
        $(this).closest('.widget-messages').find('.content').children('.messagepage').removeClass('active');                                            // close all the pages
        $(this).closest('.widget-messages').find('.content').children('#'+$(this).data('msg')).addClass('active');                                      // and open the right one (with the same msg id)
      });
    }

    //-----  DataTables Bootstrap Fix -----//

    // if there is a dataTable present
    if($('.dataTable').length > 0){

      /* Set the defaults for DataTables initialisation */
      $.extend( true, $.fn.dataTable.defaults, {
            "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
            "sPaginationType": "bootstrap",
            "oLanguage": {
              "sLengthMenu": "_MENU_ records per page"
            }
      } );

      /* Default class modification */
      $.extend( $.fn.dataTableExt.oStdClasses, {
        "sWrapper": "dataTables_wrapper form-inline"
      } );

      /* API method to get paging information */
      $.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings ){
        return {
          "iStart":         oSettings._iDisplayStart,
          "iEnd":           oSettings.fnDisplayEnd(),
          "iLength":        oSettings._iDisplayLength,
          "iTotal":         oSettings.fnRecordsTotal(),
          "iFilteredTotal": oSettings.fnRecordsDisplay(),
          "iPage":          Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
          "iTotalPages":    Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
        };
      };


      /* Bootstrap style pagination control */
      $.extend( $.fn.dataTableExt.oPagination, {
        "bootstrap": {
          "fnInit": function( oSettings, nPaging, fnDraw ) {
            var oLang = oSettings.oLanguage.oPaginate;
            var fnClickHandler = function ( e ) {
              e.preventDefault();
              if ( oSettings.oApi._fnPageChange(oSettings, e.data.action) ) {
                fnDraw( oSettings );
              }
            };

            $(nPaging).addClass('pagination').append(
              '<ul>'+
                '<li class="prev disabled"><a href="#">&larr; '+oLang.sPrevious+'</a></li>'+
                '<li class="next disabled"><a href="#">'+oLang.sNext+' &rarr; </a></li>'+
              '</ul>'
            );
            var els = $('a', nPaging);
            $(els[0]).bind( 'click.DT', { action: "previous" }, fnClickHandler );
            $(els[1]).bind( 'click.DT', { action: "next" }, fnClickHandler );
          },

          "fnUpdate": function ( oSettings, fnDraw ) {
            var iListLength = 5;
            var oPaging = oSettings.oInstance.fnPagingInfo();
            var an = oSettings.aanFeatures.p;
            var i, j, sClass, iStart, iEnd, iHalf=Math.floor(iListLength/2);

            if ( oPaging.iTotalPages < iListLength) {
              iStart = 1;
              iEnd = oPaging.iTotalPages;
            }
            else if ( oPaging.iPage <= iHalf ) {
              iStart = 1;
              iEnd = iListLength;
            } else if ( oPaging.iPage >= (oPaging.iTotalPages-iHalf) ) {
              iStart = oPaging.iTotalPages - iListLength + 1;
              iEnd = oPaging.iTotalPages;
            } else {
              iStart = oPaging.iPage - iHalf + 1;
              iEnd = iStart + iListLength - 1;
            }

            for ( i=0, iLen=an.length ; i<iLen ; i++ ) {
              // Remove the middle elements
              $('li:gt(0)', an[i]).filter(':not(:last)').remove();

              // Add the new list items and their event handlers
              for ( j=iStart ; j<=iEnd ; j++ ) {
                sClass = (j==oPaging.iPage+1) ? 'class="active"' : '';
                $('<li '+sClass+'><a href="#">'+j+'</a></li>')
                  .insertBefore( $('li:last', an[i])[0] )
                  .bind('click', function (e) {
                    e.preventDefault();
                    oSettings._iDisplayStart = (parseInt($('a', this).text(),10)-1) * oPaging.iLength;
                    fnDraw( oSettings );
                  } );
              }

              // Add / remove disabled classes from the static elements
              if ( oPaging.iPage === 0 ) {
                $('li:first', an[i]).addClass('disabled');
              } else {
                $('li:first', an[i]).removeClass('disabled');
              }

              if ( oPaging.iPage === oPaging.iTotalPages-1 || oPaging.iTotalPages === 0 ) {
                $('li:last', an[i]).addClass('disabled');
              } else {
                $('li:last', an[i]).removeClass('disabled');
              }
            }
          }
        }
      } );

      /*
       * TableTools Bootstrap compatibility
       * Required TableTools 2.1+
       */
      if ( $.fn.DataTable.TableTools ) {
        // Set the classes that TableTools uses to something suitable for Bootstrap
        $.extend( true, $.fn.DataTable.TableTools.classes, {
          "container": "DTTT btn-group",
          "buttons": {
            "normal": "btn",
            "disabled": "disabled"
          },
          "collection": {
            "container": "DTTT_dropdown dropdown-menu",
            "buttons": {
              "normal": "",
              "disabled": "disabled"
            }
          },
          "print": {
            "info": "DTTT_print_info modal"
          },
          "select": {
            "row": "active"
          }
        } );

        // Have the collection use a bootstrap compatible dropdown
        $.extend( true, $.fn.DataTable.TableTools.DEFAULTS.oTags, {
          "collection": {
            "container": "ul",
            "button": "li",
            "liner": "a"
          }
        } );
      }

      $('.dataTable').dataTable( {
          "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
          "sPaginationType": "bootstrap",
          "oLanguage": {
            "sLengthMenu": messages.patientportal.gsp.label.entries()+" _MENU_ "
          }
      });
    }


    //-----  Widget-Tasks -----//

    $('.list-close').click(function(e){
      e.preventDefault();
        $(this).closest('li').fadeOut('fast');
    });

    //-----  Top menu functions -----//

    $('#user-dropdown-button').click(function(e){
      e.preventDefault();
      $('#mail-dropdown').hide('fast');
      $('#notify-dropdown').hide('fast');

      $('#user-dropdown').toggle('fast', function(){
        $('#user-dropdown').css('overflow','');
      });
    });
    $('#mail-dropdown-button').click(function(e){
      e.preventDefault();
      $('#user-dropdown').hide('fast');
      $('#notify-dropdown').hide('fast');

      $('#mail-dropdown').toggle('fast', function(){
        $('#user-dropdown').css('overflow','');
      });
    });
    $('#notify-dropdown-button').click(function(e){
      e.preventDefault();
      $('#mail-dropdown').hide('fast');
      $('#user-dropdown').hide('fast');

      $('#notify-dropdown').toggle('fast', function(){
        $('#user-dropdown').css('overflow','');
      });
    });

    //-----  Widget menu functions -----//

    $('.widget-header .widget-minimize').click(function(e){
        e.preventDefault();
        // if the header is empty but we'd like to be able to minimize it anyway then just minimize the body to 50px
        if($(this).closest('.widget-header').hasClass('empty')){
          $(this).closest('.widget').find('.widget-body').css('height','50');
          
          if(!$(this).closest('.widget').hasClass('minimized')){
              $(this).closest('.widget').addClass('minimized');
              $(this).closest('.widget').find('.widget-body').css('height','50');
          }else{
              $(this).closest('.widget').removeClass('minimized');
              $(this).closest('.widget').children('div').css('margin','');
              $(this).closest('.widget').children('div:last-child').css('height','');
              $(this).closest('.widget').find('.widget-body').css('height','');
          }

        }else{
          $(this).closest('.widget').find('.widget-body').toggle('blind');
          
          if(!$(this).closest('.widget').hasClass('minimized')){
              $(this).closest('.widget').addClass('minimized');
              $(this).closest('.widget').children('div').css('margin','0');
              $(this).closest('.widget').children('div:last-child').css('height','auto');
          }else{
              $(this).closest('.widget').removeClass('minimized');

              $(this).closest('.widget').children('div').css('margin','');
              $(this).closest('.widget').children('div:last-child').css('height','');
          }
        }
    });
    $('.widget-header .widget-close').click(function(e){
      e.preventDefault();
        $(this).closest('.widget').fadeOut('fast', function(){
            $(this).remove();
        });
    });

    // Minimize all
    $('.minimize-all').click(function(){

      
      if(!$(this).hasClass('phase1')){        // 1. minimize the widgets first
        $(this).addClass('phase1');
      }else if(!$(this).hasClass('phase2')){  // 2. then minimize the groups
        $(this).addClass('phase2');
        $('.group').each(function(){
          $(this).slideUp();
        });
      }

      $('.widget').each(function(){
        
        if(!$(this).hasClass('nominimize')){  // if there's a nominimize class on the widget then do nothing!
          if($(this).find('.widget-header').hasClass('empty')){   // if the header is empty but we'd like to be able to minimize it anyway then just minimize the body to 50px
            if(!$(this).hasClass('minimized')){
                $(this).addClass('minimized');
                $(this).find('.widget-body').css('height','50');
            }
          }else{
            $(this).find('.widget-body').slideUp();
            if(!$(this).hasClass('minimized')){
                $(this).addClass('minimized');
                $(this).children('div').css('margin','0');
                $(this).children('div:last-child').css('height','auto');
            }
          }
        }
      });
    });

    // Maximize all
    $('.maximize-all').click(function(){

      if($('.minimize-all').hasClass('phase2')){      // 1. if it's in phase2 then maximize the group first 
        $('.minimize-all').removeClass('phase2');
        $('.group').each(function(){
          $(this).slideDown();
        });
      }else{ 
        $('.minimize-all').removeClass('phase1');     // 2. if it's not on phase2 then maximize the widgets
        $('.widget').each(function(){
          if(!$(this).hasClass('nominimize')){        // if there's a nominimize class on the widget then do nothing!
            if($(this).find('.widget-header').hasClass('empty')){   // if the header is empty but we'd like to be able to minimize it anyway then just minimize the body to 50px
              if($(this).hasClass('minimized')){
                $(this).removeClass('minimized');
                $(this).children('div').css('margin','');
                $(this).children('div:last-child').css('height','');
                $(this).find('.widget-body').css('height','');
              }
            }else{
              $(this).find('.widget-body').slideDown();
              
              if($(this).hasClass('minimized')){
                $(this).removeClass('minimized');
                $(this).children('div').css('margin','');
                $(this).children('div:last-child').css('height','');
              }
            }
          }
        });
      }
    });
    // Minimize group
    $('.minimize-group').click(function(){
      $(this).closest('.row-fluid').next('.group').slideUp();
    });
    // Maximize group
    $('.maximize-group').click(function(){
      $(this).closest('.row-fluid').next('.group').slideDown();
    });

    //-----  Various -----//

    // Activate Slimscroll on widget elements
    if($('.widget-tall .slimscroll').length > 0){
      $('.widget-tall .slimscroll').slimScroll({
          height: '575px'
      });
    }
    if($('.widget .slimscroll').length > 0){
      $('.widget .slimscroll').slimScroll({
          height: '250px'
      });
    }
    if($('.slimscroll_300').length > 0){
      $('.slimscroll_300').slimScroll({
          height: '300px'
      });
    }
    if($('.slimscroll_250').length > 0){
      $('.slimscroll_250').slimScroll({
          height: '250px'
      });
    }
	if($('.slimscroll_150').length > 0){
      $('.slimscroll_150').slimScroll({
          height: '150px'
      });
    }
    // Activate tooltips
    $('.tip').tooltip({
      top:'0'
    });
    // Activate popover
    $('.pop').popover();


    //-----  Window Resize -----//

    // redraw charts/pies/bars if the window is resized
    var didresize = false;
    $(window).resize(function() {
        didresize = true;
    });
    setInterval(function() {
        if ( didresize ) {
            didresize = false;

            if($('#dashboard_page').length > 0){ 
              redraw_dashboard();
            }
            if($('#analytics_page').length > 0){ 
              redraw_analytics();
            }
            if($('#analytics_morris_page').length > 0){ 
              redraw_analytics_morris();
            }
            if($('#analytics_flotr2_page').length > 0){ 
              redraw_analytics_flotr2();
            }
            if($('#analytics_chartjs_page').length > 0){ 
              redraw_analytics_chartjs();
            }
        }
    }, 3000);

    //-----  Dashboard page -----//

    if($('#dashboard_page').length > 0 ){
        redraw_dashboard();

        // sparkline plugin
        $('.inlinesparkline').sparkline('html', {
          width:'100%',
          height:'30',
          lineColor: '#42C1F7',
          fillColor: '#B3E6FC'
        });

        
    }
    //-----  Users page and Tables Page -----//
    if($('#users_page, #tables_page').length > 0 ){

    } 
    //-----  Forms pages -----//
    if($('#forms_wizard_page').length > 0 ){

        // tags in the wizard
       $("#wizard_tags").select2({
        tags:["Modern", "Lightweight", "Minimalistic"],
        maximumInputLength: 4
        });
       $("#wizard_validate_tags").select2({
        tags:["Modern", "Lightweight", "Minimalistic"],
        maximumInputLength: 4
        });

        // wizard with simple validation
        $('#wizard_validate').bootstrapWizard({onNext: function(tab, navigation, index) {
         // clean of error style
         $('#wizard_validate').find('.control-group').removeClass('error');
          switch(index){
            // wizard tab nr. 1
            case 1:
              // check if the title is empty or has fewer characters then 4
              if($('#val_title').val() == "" || $('#val_title').val().length < 3){
                // add error class if field is empty
                $('#val_title').closest('.control-group').addClass('error');
                return false;
              }

              // check if the description is empty
              if($('#val_description').val() == ""){
                // add error class if field is empty
                $('#val_description').closest('.control-group').addClass('error');
                return false;
              }
            break;
            // wizard tab nr. 2
            case 2:
              // check if the price is empty
              if($('#val_price').val() == ""){
                // add error class if field is empty
                $('#val_price').closest('.control-group').addClass('error');
                return false;
              }
              // check if the tags input is empty
              if($('#wizard_validate_tags').val() == ""){
                // add error class if field is empty
                $('#wizard_validate_tags').closest('.control-group').addClass('error');
                return false;
              }
            break;
            // wizard tab nr. 3 - The last one
            case 3:
              // if everything is ok we can go ahead and submit the form
              // $('#id_of_our_form').submit();
            break;
          }

        },onTabShow: function(tab, navigation, index) {
          var $total = navigation.find('li').length;
          var $current = index+1;
          var $percent = ($current/$total) * 100;
          $('#wizard_validate').find('.bar').css({width:$percent+'%'});
        }});

        // normal wizard without validation
        $('#wizard').bootstrapWizard({onNext: function(tab, navigation, index) {

        },onTabShow: function(tab, navigation, index) {
          var $total = navigation.find('li').length;
          var $current = index+1;
          var $percent = ($current/$total) * 100;
          $('#wizard').find('.bar').css({width:$percent+'%'});
        }});

        // validation
        $('#register_form1').validate({
          errorClass: "help-inline",
          errorElement: "span",
          rules: {
              username: {
                minlength: 3,
                maxlength: 15,
                required: true,

                // uncomment the line below if you want to check if the username is already taken.  Put an url to a page which receives the username via GET and return a true/false boolean. true if the username is available false if not.
                //remote: 'url to check if user name exists'
              },
              email: {
                required: true,
                email: true
              },
              password: {
                required: true,
                minlength: 5
              },
              password_confirm: {
              required: true,
              minlength: 5,
              equalTo: "#form_password"
              }
          },
           messages: {
             username: {
              minlength: "Minimum length is 3 characters",
              maxlength: "Maximum length is 15 characters",
              remote: "Username is taken",
              required: "Please specify your username"
             },
             email: {
               required: "We need your email address",
               email: "Your email address must be in the format of name@domain.com"
             },
             password: {
               required: "Please select a password"
             },
             password_confirm: {
               required: "Please enter the same password as above",
               equalTo: "Please enter the same password as above"
             }
           },
          highlight: function(label) {
            $(label).closest('.control-group').addClass('error').removeClass('success');
          },
          success: function(label) {
            $(label).text('').closest('.control-group').addClass('success');
          }
        });  

        $('#register_form2').validate({
          errorClass: "help-block",
          errorElement: "p",
          rules: {
              username: {
                minlength: 3,
                maxlength: 15,
                required: true,

                // uncomment the line below if you want to check if the username is already taken.  Put an url to a page which receives the username via GET and return a true/false boolean. true if the username is available false if not.
                //remote: 'url to check if user name exists'
              },
              email: {
                required: true,
                email: true
              },
              password: {
                required: true,
                minlength: 5
              },
              password_confirm: {
              required: true,
              minlength: 5,
              equalTo: "#form_password"
              }
          },
           messages: {
             username: {
              minlength: "Minimum length is 3 characters",
              maxlength: "Maximum length is 15 characters",
              remote: "Username is taken",
              required: "Please specify your username"
             },
             email: {
               required: "We need your email address",
               email: "Your email address must be in the format of name@domain.com"
             },
             password: {
               required: "Please select a password"
             },
             password_confirm: {
               required: "Please enter the same password as above",
               equalTo: "Please enter the same password as above"
             }
           },
          highlight: function(label) {
            $(label).closest('.control-group').addClass('error').removeClass('success');
          },
          success: function(label) {
            $(label).text('').closest('.control-group').addClass('success');
          }
        });   
    }
    if($('#forms_page').length > 0 ){

      // Pickadate.js
      $('.pickadate-date').pickadate()
      $('.pickadate-time').pickatime()

      // Rich text editor
      var editor = new TINY.editor.edit('editor', {
        id: 'tinyeditor',
        width: 584,
        height: 175,
        cssclass: 'tinyeditor',
        controlclass: 'tinyeditor-control',
        rowclass: 'tinyeditor-header',
        dividerclass: 'tinyeditor-divider',
        controls: ['bold', 'italic', 'underline', 'strikethrough', '|', 'subscript', 'superscript', '|', 'orderedlist', 'unorderedlist', '|', 'outdent', 'indent', '|', 'leftalign', 'centeralign', 'rightalign', 'blockjustify', '|', 'unformat', '|', 'undo', 'redo', 'n', 'font', 'size', 'style', '|', 'image', 'hr', 'link', 'unlink', '|', 'print'],
        footer: true,
        fonts: ['Verdana','Arial','Georgia','Trebuchet MS'],
        xhtml: true,
        cssfile: 'custom.css',
        bodyid: 'editor',
        footerclass: 'tinyeditor-footer',
        toggle: {text: 'source', activetext: 'wysiwyg', cssclass: 'toggle'},
        resize: {cssclass: 'resize'}
      });   



      $("#select2-basic").select2();
      $("#select2-multi-value").select2();
      $("#select2-max-value").select2({maximumSelectionSize: 3});
      $("#select2-tags").select2({tags:["red", "green", "blue"],tokenSeparators: [",", " "]});

      $('.colorpicker-rgb').colorpicker({ format:'rgb'});
      $('.colorpicker-rgba').colorpicker({ format:'rgba'});
      $('.colorpicker-hex').colorpicker({ format:'hex'});

      $('.datepicker-basic').datepicker();
      $('#datepicker-years').datepicker({viewMode:2});

      $('.timepicker-12hrs').timepicker();
      $('.timepicker-24hrs').timepicker({showMeridian:false});
      $('.timepicker-seconds').timepicker({showSeconds:true});
      $('.timepicker-modal').timepicker({modalBackdrop:true,showInputs:false,template:'modal'});
    } 
    if($('#forms_wysiwyg_page').length > 0 ){

      // Rich text editor
      var editor = new TINY.editor.edit('editor', {
        id: 'tinyeditor',
        width: '100%',
        height: 175,
        cssclass: 'tinyeditor',
        controlclass: 'tinyeditor-control',
        rowclass: 'tinyeditor-header',
        dividerclass: 'tinyeditor-divider',
        controls: ['bold', 'italic', 'underline', 'strikethrough', '|', 'subscript', 'superscript', '|', 'orderedlist', 'unorderedlist', '|', 'outdent', 'indent', '|', 'leftalign', 'centeralign', 'rightalign', 'blockjustify', '|', 'unformat', '|', 'undo', 'redo', 'n', 'font', 'size', 'style', '|', 'image', 'hr', 'link', 'unlink', '|', 'print'],
        footer: true,
        fonts: ['Verdana','Arial','Georgia','Trebuchet MS'],
        xhtml: true,
        cssfile: 'custom.css',
        bodyid: 'editor',
        footerclass: 'tinyeditor-footer',
        toggle: {text: 'source', activetext: 'wysiwyg', cssclass: 'toggle'},
        resize: {cssclass: 'resize'}
      });   
    } 
    //-----  UI Features page -----//
    if($('#ui_features_page').length > 0 ){
      // Gritter
      $('#add-sticky').click(function(){

          var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'This is a sticky notice!',
            // (string | mandatory) the text inside the notification
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.',
            // (string | optional) the image to display on the left
            image: 'http://profile.ak.fbcdn.net/hprofile-ak-snc6/203244_1677040371_1334985872_q.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
          });

          // You can have it return a unique id, this can be used to manually remove it later using
          /*
          setTimeout(function(){

            $.gritter.remove(unique_id, {
              fade: true,
              speed: 'slow'
            });

          }, 6000)
          */

          return false;

        });

        $('#add-regular').click(function(){

          $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'This is a regular notice!',
            // (string | mandatory) the text inside the notification
            text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.',
            // (string | optional) the image to display on the left
            image: 'http://profile.ak.fbcdn.net/hprofile-ak-snc6/203244_1677040371_1334985872_q.jpg',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: false,
            // (int | optional) the time you want it to be alive for before fading out
            time: ''
          });

          return false;

        });

            $('#add-max').click(function(){

                $.gritter.add({
                    // (string | mandatory) the heading of the notification
                    title: 'This is a notice with a max of 3 on screen at one time!',
                    // (string | mandatory) the text inside the notification
                    text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.',
                    // (string | optional) the image to display on the left
                    image: 'http://a0.twimg.com/profile_images/59268975/jquery_avatar_bigger.png',
                    // (bool | optional) if you want it to fade out on its own or just sit there
                    sticky: false,
                    // (function) before the gritter notice is opened
                    before_open: function(){
                        if($('.gritter-item-wrapper').length == 3)
                        {
                            // Returning false prevents a new gritter from opening
                            return false;
                        }
                    }
                });

                return false;

            });

        $('#add-without-image').click(function(){

          $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'This is a notice without an image!',
            // (string | mandatory) the text inside the notification
            text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" style="color:#ccc">magnis dis parturient</a> montes, nascetur ridiculus mus.'
          });

          return false;
        });

            $('#add-gritter-dark').click(function(){

                $.gritter.add({
                    // (string | mandatory) the heading of the notification
                    title: 'This is a dark notification',
                    // (string | mandatory) the text inside the notification
                    text: 'Just add a "gritter-dark" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
                    class_name: 'gritter-dark'
                });

                return false;
            });

        $('#add-with-callbacks').click(function(){

          $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'This is a notice with callbacks!',
            // (string | mandatory) the text inside the notification
            text: 'The callback is...',
            // (function | optional) function called before it opens
            before_open: function(){
              alert('I am called before it opens');
            },
            // (function | optional) function called after it opens
            after_open: function(e){
              alert("I am called after it opens: \nI am passed the jQuery object for the created Gritter element...\n" + e);
            },
            // (function | optional) function called before it closes
            before_close: function(e, manual_close){
                        var manually = (manual_close) ? 'The "X" was clicked to close me!' : '';
              alert("I am called before it closes: I am passed the jQuery object for the Gritter element... \n" + manually);
            },
            // (function | optional) function called after it closes
            after_close: function(e, manual_close){
                        var manually = (manual_close) ? 'The "X" was clicked to close me!' : '';
              alert('I am called after it closes. ' + manually);
            }
          });

          return false;
        });

        $('#add-sticky-with-callbacks').click(function(){

          $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: 'This is a sticky notice with callbacks!',
            // (string | mandatory) the text inside the notification
            text: 'Sticky sticky notice.. sticky sticky notice...',
            // Stickeh!
            sticky: true,
            // (function | optional) function called before it opens
            before_open: function(){
              alert('I am a sticky called before it opens');
            },
            // (function | optional) function called after it opens
            after_open: function(e){
              alert("I am a sticky called after it opens: \nI am passed the jQuery object for the created Gritter element...\n" + e);
            },
            // (function | optional) function called before it closes
            before_close: function(e){
              alert("I am a sticky called before it closes: I am passed the jQuery object for the Gritter element... \n" + e);
            },
            // (function | optional) function called after it closes
            after_close: function(){
              alert('I am a sticky called after it closes');
            }
          });

          return false;

        });

        $("#remove-all").click(function(){

          $.gritter.removeAll();
          return false;

        });

        $("#remove-all-with-callbacks").click(function(){

          $.gritter.removeAll({
            before_close: function(e){
              alert("I am called before all notifications are closed.  I am passed the jQuery object containing all  of Gritter notifications.\n" + e);
            },
            after_close: function(){
              alert('I am called after everything has been closed.');
            }
          });
          return false;

        });


        // Alertify
        $('.demo_notify').click(function(){

          switch($(this).attr('data-type')){

            case 'info':
            alertify.log( 'This is a standard info notification.', 'info' );
            break;
            case 'error':
            alertify.log( 'There is an error somewhere.', 'error' );
            break;
            case 'success':
            alertify.log( 'Action was performed successfully!', 'success' );
            break;
          }
        });

        $('.demo_notify_dialog').click(function(){

          switch($(this).attr('data-type')){

            case 'alert':
            alertify.alert( 'This is an alert box.', function () {
                // after clicking OK
            });
            break;
            case 'confirm':
            alertify.confirm( 'This is a confirm box.<br>ENTER and ESC keys will trigger OK and Cancel respectively.', function (e) {
                if (e) {
                    //after clicking OK
                } else {
                    //after clicking Cancel
                }
            });
            break;
            case 'prompt':
            alertify.prompt( 'This is a prompt box.<br>ENTER and ESC keys will trigger OK and Cancel respectively.', function (e, str) {
                if (e) {
                    // after clicking OK
                    // str is the value from the textbox
                } else {
                    // after clicking Cancel
                }
            });
            break;
          }
        });
    } 
    //-----  Calendar page -----//
    if($('#calendar_page').length > 0 ){

      var date = new Date();
      var d = date.getDate();
      var m = date.getMonth();
      var y = date.getFullYear();
      
      var calendar = $('#calendar').fullCalendar({
        header: {
          left: 'prev,next today',
          center: 'title',
          right: 'month,agendaWeek,agendaDay'
        },
        selectable: true,
        selectHelper: true,
        select: function(start, end, allDay) {
          var title = prompt('Event Title:');
          if (title) {
            calendar.fullCalendar('renderEvent',
              {
                title: title,
                start: start,
                end: end,
                allDay: allDay
              },
              true // make the event "stick"
            );
          }
          calendar.fullCalendar('unselect');
        },
        editable: true,
        events: [
          {
            title: 'All Day Event',
            start: new Date(y, m, 1)
          },
          {
            title: 'Long Event',
            start: new Date(y, m, d-5),
            end: new Date(y, m, d-2)
          },
          {
            id: 999,
            title: 'Repeating Event',
            start: new Date(y, m, d-3, 16, 0),
            allDay: false
          },
          {
            id: 999,
            title: 'Repeating Event',
            start: new Date(y, m, d+4, 16, 0),
            allDay: false
          },
          {
            title: 'Meeting',
            start: new Date(y, m, d, 10, 30),
            allDay: false
          },
          {
            title: 'Lunch',
            start: new Date(y, m, d, 12, 0),
            end: new Date(y, m, d, 14, 0),
            allDay: false
          },
          {
            title: 'Birthday Party',
            start: new Date(y, m, d+1, 19, 0),
            end: new Date(y, m, d+1, 22, 30),
            allDay: false
          },
          {
            title: 'Click for Google',
            start: new Date(y, m, 28),
            end: new Date(y, m, 29),
            url: 'http://google.com/'
          }
        ]
      });  
    }
    //-----  Gallery page -----//
    if($('#gallery_page').length > 0 ){

      var $container = $('#gallery-container');
      var gutter_width = 6;
      var min_width = 250;

      var imgs = $('.gallery-item img');

      imgs.each(function () {
        var img = $(this);
        if(img[0].complete || ($.browser.msie && parseInt($.browser.version) == 6)){
          img.trigger("load");
        }
      }); 
      imgs.imagesLoaded(function (){
        $container.masonry({
          itemSelector : '.gallery-item',
          gutterWidth: gutter_width,
          isAnimated: true,
          columnWidth: function( containerWidth ) {
            var items = (containerWidth/min_width | 0);
            var col_width = (((containerWidth - (items-1)*gutter_width)/items) | 0) ;
            if (containerWidth < min_width) {
              col_width = containerWidth;
            }
            $('.gallery-item').width(col_width);
            return col_width;
          }
        });
      });

      // initialize the lightbox image plugin
      $('a[rel*=facybox]').facybox();
    } 
    //-----  Analytics pages -----//
    if($('#analytics_page').length > 0 ){
      redraw_analytics();
    }
    if($('#analytics_morris_page').length > 0 ){
      redraw_analytics_morris();
    }
    if($('#analytics_flotr2_page').length > 0 ){
      redraw_analytics_flotr2();
    }
    if($('#analytics_chartjs_page').length > 0 ){
      redraw_analytics_chartjs();
    }
    //-----  Tasks page -----//
    if($('#tasks_page').length > 0 ){
      

      // init knob
      $(".knob").knob({
          draw : function () {}
      });

      //Get context with jQuery - using jQuery's .get() method.
      var ctx = $("#donutgraph1").get(0).getContext("2d");
      //This will get the first returned node in the jQuery collection.
      var myNewChart = new Chart(ctx);
      var data = [{ value: 50, color:"#ceab3b"},{ value : 30, color : "#55bc75"},{ value : 100, color : "#dc4c42"}];
      var option = {
          percentageInnerCutout : 50,
          scaleShowValues:true,
          scaleValuePaddingX: 35,
          scaleFontFamily : "'Open Sans'",
          scaleFontSize : 9,
          scaleFontStyle : 600,
          scaleFontColor : "#FFFFFF",
          scaleFontShowValues : false
      };
      new Chart(ctx).Doughnut(data, option);
    }
    if($('#article_page').length > 0){
      // Rich text editor
      var editor = new TINY.editor.edit('editor', {
        id: 'tinyeditor',
        width: '100%',
        height: 175,
        cssclass: 'tinyeditor',
        controlclass: 'tinyeditor-control',
        rowclass: 'tinyeditor-header',
        dividerclass: 'tinyeditor-divider',
        controls: ['bold', 'italic', 'underline', 'strikethrough', '|', 'subscript', 'superscript', '|', 'orderedlist', 'unorderedlist', '|', 'outdent', 'indent', '|', 'leftalign', 'centeralign', 'rightalign', 'blockjustify', '|', 'unformat', '|', 'undo', 'redo', 'n', 'font', 'size', 'style', '|', 'image', 'hr', 'link', 'unlink', '|', 'print'],
        footer: true,
        fonts: ['Verdana','Arial','Georgia','Trebuchet MS'],
        xhtml: true,
        cssfile: 'custom.css',
        bodyid: 'editor',
        footerclass: 'tinyeditor-footer',
        toggle: {text: 'source', activetext: 'wysiwyg', cssclass: 'toggle'},
        resize: {cssclass: 'resize'}
      });   
    }
});

function redraw_dashboard(){
    (function graph_dash1(container) {
      var   d1 = [[1, 65],[2, 75],[3, 61],[4, 65],[5, 87],[6, 77],[7, 80]], graph;

      // Draw Graph
      graph = Flotr.draw(container, [{
            data:d1,
            lines: { show:true, fill: true, fillOpacity: 1 },
            points: { show: true }
        }], {
        colors: ['#55bc75', '#dc4c42', '#ceab3b', '#dd4a29', '#b1a599'], 
        shadowSize: 0,
        fontSize:4,
        xaxis: { ticks:[1,2,3,4,5], showLabels: false },
        yaxis: { showLabels: false, min:0, max:100 },
        grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
        mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

      });
    })(document.getElementById("graph_dash1"));
    
    (function graph_dash2(container) {
      var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

      // Draw Graph
      graph = Flotr.draw(container, [{
            data:d1,
            lines: { show:true, fill: true, fillOpacity: 1 },
            points: { show: true }
        }], {
        colors: ['#3BC2E3'], 
        shadowSize: 0,
        fontSize:4,
        xaxis: { ticks:[1,2,3,4,5], showLabels: false },
        yaxis: { showLabels: false, min:0, max:100 },
        grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
        mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

      });
    })(document.getElementById("graph_dash2"));

    (function graph_dash3(container) {
      var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

      // Draw Graph
      graph = Flotr.draw(container, [{
            data:d1,
            lines: { show:true, fill: true, fillOpacity: 1 },
            points: { show: true }
        }], {
        colors: ['#DC4C42'], 
        shadowSize: 0,
        fontSize:4,
        xaxis: { ticks:[1,2,3,4,5], showLabels: false },
        yaxis: { showLabels: false, min:0, max:100 },
        grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
        mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

      });
    })(document.getElementById("graph_dash3"));
    
    (function graph_dash4(container) {
      var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

      // Draw Graph
      graph = Flotr.draw(container, [{
            data:d1,
            lines: { show:true, fill: true, fillOpacity: 1 },
            points: { show: true }
        }], {
        colors: ['#CEAB3B'], 
        shadowSize: 0,
        fontSize:4,
        xaxis: { ticks:[1,2,3,4,5], showLabels: false },
        yaxis: { showLabels: false, min:0, max:100 },
        grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
        mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

      });
    })(document.getElementById("graph_dash4"));

    (function graph_dash5(container) {
      var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

      // Draw Graph
      graph = Flotr.draw(container, [{
            data:d1,
            lines: { show:true, fill: true, fillOpacity: 1 },
            points: { show: true }
        }], {
        colors: ['#F28CCE'], 
        shadowSize: 0,
        fontSize:4,
        xaxis: { ticks:[1,2,3,4,5], showLabels: false },
        yaxis: { showLabels: false, min:0, max:100 },
        grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
        mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

      });
    })(document.getElementById("graph_dash5"));

    (function bargraph_comparison(container, horizontal) {

        var
        horizontal = (horizontal ? true : false),
            // Show horizontal bars
            d1 = [[1,41]],
            // First data series
            d2 = [[2,59]],
            // Second data series
            point, // Data point variable declaration
            i;

        // Draw the graph
        Flotr.draw( container, [{data:d1 }, {data:d2}], {
            bars: {
                show: true,
                horizontal: horizontal,
                shadowSize: 0,
                barWidth: 0.5,
                fillOpacity:1
            },
            colors: ['#3BC2E3', '#F28CCE'],
            mouse: { lineColor:'rgba(0,0,0,0.3)',track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } },
            yaxis: {
              showLabels:false,
              min: 0,
              autoscaleMargin: 1
            },
            xaxis: {
              showLabels:false
            },
            grid: { tickColor:'#DDDDDD', outlineWidth:0, verticalLines:false, horizontalLines:false, },
        });
    })(document.getElementById("bargraph_comparison"));

    (function bargraph_comparison02(container, horizontal) {

      var
      horizontal = (horizontal ? true : false),
          // Show horizontal bars
          d1 = [[1,41]],
          // First data series
          d2 = [[2,59]],
          // Third data series
          d3 = [[3,51]],
          // Second data series
          point, // Data point variable declaration
          i;

        // Draw the graph
        Flotr.draw( container, [{data:d1 }, {data:d2}, {data:d3}], {
            bars: {
                show: true,
                horizontal: horizontal,
                shadowSize: 0,
                barWidth: 0.8,
                fillOpacity:1,
                grouped:false
            },
            colors: ['#DC4C42', '#55BC75', '#3BC2E3'],
            mouse: { lineColor:'rgba(0,0,0,0.3)',track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } },
            yaxis: {
              showLabels:false,
              min: 0,
              autoscaleMargin: 1,
              margin:false
            },
            xaxis: {
              showLabels:false,
              margin:false
            },
            grid: { tickColor:'#DDDDDD', outlineWidth:0, verticalLines:false, horizontalLines:false, },
        });
    })(document.getElementById("bargraph_comparison02"));

    (function linegraph(container) {
        var   d1 = [[0,0],[1, 65],[2, 75],[3, 61],[4, 65],[5, 87],[6,0]],
              d2 = [[0,0],[1, 40],[2, 45],[3, 60],[4, 52],[5, 70],[6,0]], 
              d3 = [[0,0],[1, 41],[2, 25],[3, 40],[4, 72],[5, 78],[6,0]], 
              graph;

        // Draw Graph
        graph = Flotr.draw(container, [{
              data:d1,
              lines: {
                  show:true,
                  fill: true
              },
              points: {
                  show: true
              }
          },{
              data:d2,
              lines: {
                  show:true,
                  fill: true
              },
              points: {
                  show: true
              }
          },{
              data:d3,
              lines: {
                  show:true,
                  fill: true
              },
              points: {
                  show: true
              }
          }], {
          colors: ['#CEAB3B', '#3BC2E3', '#55BC75'], 
          shadowSize: 0,
          fontSize:4,
          xaxis: {
              showLabels: false
          },
          yaxis: {
              showLabels: false,
              min:0,
              max:100
          },
          grid: {
              outlineWidth:0,  
              verticalLines:false,
              horizontalLines:false,
              minorVerticalLines: false
          },
          mouse: {
              track: true,
              relative:true,
              trackDecimals: 0,
              trackFormatter: function(obj) {
                  return obj.y+' users';
              }
          }
        });
    })(document.getElementById("linegraph"));

    (function graph_visits(container) {
      var   d1 = [[1, 65],[2, 75],[3, 61],[4, 65],[5, 87],[6, 98],[7, 102],[8, 79],[9, 88],[10, 97],[11, 99],[12, 135],[13, 167],[14, 190],[15, 260],[16, 288],[17, 291],[18, 357],[19, 431],[20, 444],[21, 490],[22, 532],[23, 487],[24, 490],[25, 580],[26, 597],[27, 642],[28, 654],[29, 677],[30, 690],[31, 751]],
            d2 = [[1, 40],[2, 45],[3, 60],[4, 52],[5, 70],[6, 52],[7, 45],[8, 40],[9, 45],[10, 20],[11, 80],[12, 50],[13, 55],[14, 56],[15, 80],[16, 40],[17, 21],[18, 58],[19, 67],[20, 121],[21, 122],[22, 135],[23, 210],[24, 219],[25, 242],[26, 291],[27, 281],[28, 308],[29, 346],[30, 397],[31, 454]], 
            graph;

      // Draw Graph
      graph = Flotr.draw(container, [{
            data:d1,
            label:'Total Users',
            lines: {
                show:true,
                fill: true
            },
            points: {
                show: true
            }
        },{
            data:d2,
            label:'Unique Users',
            lines: {
                show:true,
                fill: true
            },
            points: {
                show: true
            }
        }], {
        colors: ['#55bc75', '#dc4c42', '#ceab3b', '#dd4a29', '#b1a599'], 
        shadowSize: 0,
        fontSize:4,
        xaxis: {
            ticks:[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31],
            showLabels: true
        },
        yaxis: {
            ticks:[100,200,300,400,500,600,700,800],
            showLabels: true,
            min:0,
            max:800
        },
        grid: {
            outlineWidth:0,  
            verticalLines:true,
            horizontalLines:true,
            minorVerticalLines: true
        },
        mouse: {
            track: true,
            relative:true,
            trackDecimals: 0,
            trackFormatter: function(obj) {
                return obj.y+' users';
            }
        }
      });
    })(document.getElementById("graph_visits"));

    //Get context with jQuery - using jQuery's .get() method.
    var ctx = $("#donutgraph").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var myNewChart = new Chart(ctx);
    var data = [{ value: 50, color:"#ceab3b"},{ value : 30, color : "#55bc75"},{ value : 100, color : "#dc4c42"}];
    var option = {
        percentageInnerCutout : 50,
        scaleShowValues:true,
        scaleValuePaddingX: 35,
        scaleFontFamily : "'Open Sans'",
        scaleFontSize : 9,
        scaleFontStyle : 600,
        scaleFontColor : "#FFFFFF",
        scaleFontShowValues : false
    };
    new Chart(ctx).Doughnut(data, option);

    // VECTOR MAP
    jQuery('#widget_vector_map').vectorMap({
        map: 'world_en',
        backgroundColor: 'rgba(0,0,0,0)',
        color: '#CCFFDB',
        hoverOpacity: 0.7,
        selectedColor: '#97EFB1',
        enableZoom: true,
        showTooltip: true,
        values: sample_data,
        scaleColors: ['#55bc75', '#76DB94'],
        normalizeFunction: 'polynomial'
    });

    // FULL CALENDAR
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    $('#widget_fullcalendar').html('');

    var calendar = $('#widget_fullcalendar').fullCalendar({ header:false, height:190, selectable: true, 
            selectHelper: true,
            select: function(start, end, allDay) {
                var title = prompt('Event Title:');
                if (title) {
                    calendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay
                        },
                        true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            editable: true, 
            events: [
            {
                title: 'Finish Report',
                start: new Date(y, m, 2),
                end: new Date(y, m, 3)
            },
            {
                title: 'Long Event',
                start: new Date(y, m, 19),
                end: new Date(y, m, 25)
            },
            {
                title: 'Click for Google',
                start: new Date(y, m, 28),
                end: new Date(y, m, 29),
                url: 'http://google.com/'
            }
        ]
    });
}

//-----  Analytics pages -----//

function redraw_analytics(){ 
  $('.chart').html('');

  (function graph_dash1(container) {
    var   d1 = [[1, 65],[2, 75],[3, 61],[4, 65],[5, 87],[6, 77],[7, 80]], graph;

    // Draw Graph
    graph = Flotr.draw(container, [{
          data:d1,
          lines: { show:true, fill: true, fillOpacity: 1 },
          points: { show: true }
      }], {
      colors: ['#55bc75', '#dc4c42', '#ceab3b', '#dd4a29', '#b1a599'], 
      shadowSize: 0,
      fontSize:4,
      xaxis: { ticks:[1,2,3,4,5], showLabels: false },
      yaxis: { showLabels: false, min:0, max:100 },
      grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
      mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

    });
  })(document.getElementById("graph_dash1"));
  
  (function graph_dash2(container) {
    var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

    // Draw Graph
    graph = Flotr.draw(container, [{
          data:d1,
          lines: { show:true, fill: true, fillOpacity: 1 },
          points: { show: true }
      }], {
      colors: ['#3BC2E3'], 
      shadowSize: 0,
      fontSize:4,
      xaxis: { ticks:[1,2,3,4,5], showLabels: false },
      yaxis: { showLabels: false, min:0, max:100 },
      grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
      mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

    });
  })(document.getElementById("graph_dash2"));

  (function graph_dash3(container) {
    var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

    // Draw Graph
    graph = Flotr.draw(container, [{
          data:d1,
          lines: { show:true, fill: true, fillOpacity: 1 },
          points: { show: true }
      }], {
      colors: ['#DC4C42'], 
      shadowSize: 0,
      fontSize:4,
      xaxis: { ticks:[1,2,3,4,5], showLabels: false },
      yaxis: { showLabels: false, min:0, max:100 },
      grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
      mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

    });
  })(document.getElementById("graph_dash3"));

  (function graph_dash4(container) {
    var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

    // Draw Graph
    graph = Flotr.draw(container, [{
          data:d1,
          lines: { show:true, fill: true, fillOpacity: 1 },
          points: { show: true }
      }], {
      colors: ['#D6CC48'], 
      shadowSize: 0,
      fontSize:4,
      xaxis: { ticks:[1,2,3,4,5], showLabels: false },
      yaxis: { showLabels: false, min:0, max:100 },
      grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
      mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

    });
  })(document.getElementById("graph_dash4"));

  (function graph_dash5(container) {
    var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

    // Draw Graph
    graph = Flotr.draw(container, [{
          data:d1,
          lines: { show:true, fill: true, fillOpacity: 1 },
          points: { show: true }
      }], {
      colors: ['#b1a599'], 
      shadowSize: 0,
      fontSize:4,
      xaxis: { ticks:[1,2,3,4,5], showLabels: false },
      yaxis: { showLabels: false, min:0, max:100 },
      grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
      mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

    });
  })(document.getElementById("graph_dash5"));

  (function graph_dash6(container) {
    var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87]], graph;

    // Draw Graph
    graph = Flotr.draw(container, [{
          data:d1,
          lines: { show:true, fill: true, fillOpacity: 1 },
          points: { show: true }
      }], {
      colors: ['#3DD3C4'], 
      shadowSize: 0,
      fontSize:4,
      xaxis: { ticks:[1,2,3,4,5], showLabels: false },
      yaxis: { showLabels: false, min:0, max:100 },
      grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
      mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

    });
  })(document.getElementById("graph_dash6"));
  
  (function graph_dash7(container) {
    var   d1 = [[1, 55],[2, 65],[3, 55],[4, 58],[5, 55],[6, 75],[7, 87],[8, 90],[9, 94],[10, 112],[11, 122],[12, 130],[13, 139],[14, 150]], graph;

    // Draw Graph
    graph = Flotr.draw(container, [{
          data:d1,
          lines: { show:true, fill: true, fillOpacity: 1 },
          points: { show: true }
      }], {
      colors: ['#87F2E9'], 
      shadowSize: 0,
      fontSize:4,
      xaxis: { ticks:[1,2,3,4,5], showLabels: false },
      yaxis: { showLabels: false, min:0, max:150 },
      grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, },
      mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } }

    });
  })(document.getElementById("graph_dash7"));

  // sparkline plugin
  $('.inlinesparkline').sparkline('html', {
    width:'100%',
    height:'30',
    lineColor: '#42C1F7',
    fillColor: '#B3E6FC'
  });
  (function linegraph_analytics_page01(container) {
    var   d1 = [[0,0],[1, 65],[2, 75],[3, 61],[4, 65],[5, 87],[6,0]],
          d2 = [[0,0],[1, 40],[2, 45],[3, 60],[4, 52],[5, 70],[6,0]], 
          d3 = [[0,0],[1, 41],[2, 25],[3, 40],[4, 72],[5, 78],[6,0]], 
          graph;

    // Draw Graph
    graph = Flotr.draw(container, [
      { data:d1, lines: { show:true, fill: true }, points: { show: true}},
      { data:d2, lines: { show:true, fill: true }, points: { show: true }},
      { data:d3, lines: { show:true, fill: true }, points: { show: true }}], 
      { colors: ['#CEAB3B', '#3BC2E3', '#55BC75'],  shadowSize: 0, fontSize:4, 
        xaxis: { showLabels: false },
        yaxis: { showLabels: false, min:0, max:100 },
        grid: { outlineWidth:0, verticalLines:false, horizontalLines:false, minorVerticalLines: false },
        mouse: { track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.y+' users'; } 
      }
    });
  })(document.getElementById("linegraph_analytics_page01"));

  (function bargraph_analytics_page01(container, horizontal) {

      var
      horizontal = (horizontal ? true : false),
          d1 = [[1,41]], d2 = [[2,59]], d3 = [[3,51]], point;

      // Draw the graph
      Flotr.draw( container, [{data:d1 }, {data:d2}, {data:d3}], {
          bars: { show: true, horizontal: horizontal, shadowSize: 0, barWidth: 0.8, fillOpacity:1, grouped:false },
          colors: ['#DC4C42', '#55BC75', '#3BC2E3'],
          mouse: { lineColor:'rgba(0,0,0,0.3)',track: true, relative:true, trackDecimals: 0, trackFormatter: function(obj) { return obj.x+'. May: '+obj.y+' users'; } },
          yaxis: { showLabels:false, min: 0, autoscaleMargin: 1, margin:false },
          xaxis: { showLabels:false, margin:false },
          grid: { tickColor:'#DDDDDD', outlineWidth:0, verticalLines:false, horizontalLines:false, },
      });
  })(document.getElementById("bargraph_analytics_page01"));
}  
function redraw_analytics_morris(){

  Morris.Donut({
    element: 'donut1',
    data: [
      {label: "Visits Today", value: 1503},
      {label: "Visits Yesterday", value: 2190}
    ],
    colors:['#DC4C42','#3BC2E3']
  });

  Morris.Donut({
    element: 'donut2',
    data: [
      {label: "% New visitors", value: 30},
      {label: "% Returning visitors", value: 70}
    ],
    colors:['#DC4C42','#3BC2E3']
  });

  Morris.Donut({
    element: 'donut3',
    data: [
      {label: "Firefox", value: 5798},
      {label: "Chrome", value: 4855},
      {label: "Internet Explorer", value: 2877}
    ],
    colors:['#DC4C42','#3BC2E3','#55BC75']
  });

  Morris.Donut({
    element: 'donut4',
    data: [
      {label: "Categories", value: 8790},
      {label: "Clothing", value: 7052},
      {label: "About", value: 6577},
    ],
    colors:['#DC4C42','#3BC2E3','#55BC75']
  });
 // quarterly data, custom colors, skinny lines
  Morris.Area({
    element: 'areachart',
    data: [
      {x: '2012-01-01', y: 102},
      {x: '2012-01-10', y: 172},
      {x: '2012-01-20', y: 130},
      {x: '2012-02-01', y: 198},
      {x: '2012-02-10', y: 256},
      {x: '2012-02-20', y: 211},
      {x: '2012-03-01', y: 345},
      {x: '2012-03-10', y: 456},
      {x: '2012-03-20', y: 384},
      {x: '2012-04-01', y: 584}
    ],
    xkey: 'x',
    ykeys: ['y'],
    smooth: false,
    lineColors: ['#42C1F7','#B3E6FC'],
    labels: ['Y', 'Z']
  });

  Morris.Area({
    element: 'areachart2',
    data: [
      {x: '2012-01-01', y: 102, z:100},
      {x: '2012-01-10', y: 172, z:150},
      {x: '2012-01-20', y: 130, z:110},
      {x: '2012-02-01', y: 198, z:180},
      {x: '2012-02-10', y: 256, z:220},
      {x: '2012-02-20', y: 211, z:200},
      {x: '2012-03-01', y: 345, z:320},
      {x: '2012-03-10', y: 456, z:400},
      {x: '2012-03-20', y: 384, z:300},
      {x: '2012-04-01', y: 584, z:500}
    ],
    xkey: 'x',
    ykeys: ['y', 'z'],
    smooth: false,
    lineColors: ['#42C1F7','#65A7BF'],
    labels: ['Y', 'Z']
  });

  Morris.Line({
    element: 'linechart',
    data: [
      {x: '2012-01-01', y: 102},
      {x: '2012-01-10', y: 172},
      {x: '2012-01-20', y: 130},
      {x: '2012-02-01', y: 198},
      {x: '2012-02-10', y: 256},
      {x: '2012-02-20', y: 211},
      {x: '2012-03-01', y: 345},
      {x: '2012-03-10', y: 456},
      {x: '2012-03-20', y: 384},
      {x: '2012-04-01', y: 584}
    ],
    xkey: 'x',
    ykeys: ['y'],
    smooth: false,
    lineColors: ['#42C1F7','#B3E6FC'],
    labels: ['Y']
  });

  Morris.Line({
    element: 'linechart2',
    data: [
      {x: '2012-01-01', y: 102, z:100},
      {x: '2012-01-10', y: 172, z:150},
      {x: '2012-01-20', y: 130, z:110},
      {x: '2012-02-01', y: 198, z:180},
      {x: '2012-02-10', y: 256, z:220},
      {x: '2012-02-20', y: 211, z:200},
      {x: '2012-03-01', y: 345, z:320},
      {x: '2012-03-10', y: 456, z:400},
      {x: '2012-03-20', y: 384, z:300},
      {x: '2012-04-01', y: 584, z:500}
    ],
    xkey: 'x',
    ykeys: ['y', 'z'],
    smooth: false,
    lineColors: ['#42C1F7','#B3E6FC'],
    labels: ['Y', 'Z']
  });
  Morris.Bar({
    element: 'barchart',
    data: [
      {x: '2012-01-01', y: 102, z:100},
      {x: '2012-01-10', y: 172, z:150},
      {x: '2012-01-20', y: 130, z:110},
      {x: '2012-02-01', y: 198, z:180},
      {x: '2012-02-10', y: 256, z:220},
      {x: '2012-02-20', y: 211, z:200},
      {x: '2012-03-01', y: 345, z:320},
      {x: '2012-03-10', y: 456, z:400},
      {x: '2012-03-20', y: 384, z:300},
      {x: '2012-04-01', y: 584, z:500}
    ],
    xkey: 'x',
    ykeys: ['y', 'z'],
    barColors: ['#42C1F7','#B3E6FC'],
    labels: ['Y', 'Z']
  });
}
function redraw_analytics_flotr2(){


  /******************/
  /* BASIC CHART
  /******************/

  (function flotr1(container) {

      var
      d1 = [ [0, 3], [4, 8], [8, 5], [9, 13] ],
          // First data series
          d2 = [],
          // Second data series
          i, graph;

      // Generate first data set
      for (i = 0; i < 14; i += 0.5) {
          d2.push([i, Math.sin(i)]);
      }

      // Draw Graph
      graph = Flotr.draw(container, [d1, d2], {
          xaxis: {
              minorTickFreq: 4
          },
          grid: {
              minorVerticalLines: true
          }
      });
  })(document.getElementById("flotr1"));

  /******************/
  /* BASIC AXIS
  /******************/

  (function flotr2(container) {

      var
      d1 = [], d2 = [], d3 = [], d4 = [], d5 = [],
          // Data
          ticks = [
              [0, "Lower"], 10, 20, 30, [40, "Upper"]
          ],
          // Ticks for the Y-Axis
          graph;

      for (var i = 0; i <= 10; i += 0.1) {
          d1.push([i, 4 + Math.pow(i, 1.5)]);
          d2.push([i, Math.pow(i, 3)]);
          d3.push([i, i * 5 + 3 * Math.sin(i * 4)]);
          d4.push([i, i]);
          if (i.toFixed(1) % 1 == 0) {
              d5.push([i, 2 * i]);
          }
      }

      d3[30][1] = null;
      d3[31][1] = null;

      function ticksFn(n) {
          return '(' + n + ')';
      }

      graph = Flotr.draw(container, [{
          data: d1,
          label: 'y = 4 + x^(1.5)',
          lines: {
              fill: true
          }
      }, {
          data: d2,
          label: 'y = x^3'
      }, {
          data: d3,
          label: 'y = 5x + 3sin(4x)'
      }, {
          data: d4,
          label: 'y = x'
      }, {
          data: d5,
          label: 'y = 2x',
          lines: {
              show: true
          },
          points: {
              show: true
          }
      }], {
          xaxis: {
              noTicks: 7,
              // Display 7 ticks.
              tickFormatter: ticksFn,
              // Displays tick values between brackets.
              min: 1,
              // Part of the series is not displayed.
              max: 7.5 // Part of the series is not displayed.
          },
          yaxis: {
              ticks: ticks,
              // Set Y-Axis ticks
              max: 40 // Maximum value along Y-Axis
          },
          grid: {
              verticalLines: false,
              backgroundColor: {
                  colors: [
                      [0, '#fff'],
                      [1, '#ccc']
                  ],
                  start: 'top',
                  end: 'bottom'
              }
          },
          legend: {
              position: 'nw'
          }
      });
  })(document.getElementById("flotr2"));

  /******************/
  /* BASIC BARS
  /******************/

  (function flotr3(container, horizontal) {

      var
      horizontal = (horizontal ? true : false),
          // Show horizontal bars
          d1 = [],
          // First data series
          d2 = [],
          // Second data series
          point, // Data point variable declaration
          i;

      for (i = 0; i < 4; i++) {

          if (horizontal) {
              point = [Math.ceil(Math.random() * 10), i];
          } else {
              point = [i, Math.ceil(Math.random() * 10)];
          }

          d1.push(point);

          if (horizontal) {
              point = [Math.ceil(Math.random() * 10), i + 0.5];
          } else {
              point = [i + 0.5, Math.ceil(Math.random() * 10)];
          }

          d2.push(point);
      };

      // Draw the graph
      Flotr.draw(
      container, [d1, d2], {
          bars: {
              show: true,
              horizontal: horizontal,
              shadowSize: 0,
              barWidth: 0.5
          },
          mouse: {
              track: true,
              relative: true
          },
          yaxis: {
              min: 0,
              autoscaleMargin: 1
          }
      });
  })(document.getElementById("flotr3"));

  /******************/
  /* HORIZONTAL BARS
  /******************/

  (function flotr4(container, horizontal) {

      var
      horizontal = (horizontal ? true : false),
          // Show horizontal bars
          d1 = [],
          // First data series
          d2 = [],
          // Second data series
          point, // Data point variable declaration
          i;

      for (i = 0; i < 4; i++) {

          if (horizontal) {
              point = [Math.ceil(Math.random() * 10), i];
          } else {
              point = [i, Math.ceil(Math.random() * 10)];
          }

          d1.push(point);

          if (horizontal) {
              point = [Math.ceil(Math.random() * 10), i + 0.5];
          } else {
              point = [i + 0.5, Math.ceil(Math.random() * 10)];
          }

          d2.push(point);
      };

      // Draw the graph
      Flotr.draw(
      container, [d1, d2], {
          bars: {
              show: true,
              horizontal: horizontal,
              shadowSize: 0,
              barWidth: 0.5
          },
          mouse: {
              track: true,
              relative: true
          },
          yaxis: {
              min: 0,
              autoscaleMargin: 1
          }
      });
  })(document.getElementById("flotr4"),true);

  /******************/
  /* STACKED BARS
  /******************/

  (function flotr5(container, horizontal) {

      var
      d1 = [],
          d2 = [],
          d3 = [],
          graph, i;

      for (i = -10; i < 10; i++) {
          if (horizontal) {
              d1.push([Math.random(), i]);
              d2.push([Math.random(), i]);
              d3.push([Math.random(), i]);
          } else {
              d1.push([i, Math.random()]);
              d2.push([i, Math.random()]);
              d3.push([i, Math.random()]);
          }
      }

      graph = Flotr.draw(container, [{
          data: d1,
          label: 'Serie 1'
      }, {
          data: d2,
          label: 'Serie 2'
      }, {
          data: d3,
          label: 'Serie 3'
      }], {
          legend: {
              backgroundColor: '#D2E8FF' // Light blue 
          },
          bars: {
              show: true,
              stacked: true,
              horizontal: horizontal,
              barWidth: 0.6,
              lineWidth: 1,
              shadowSize: 0
          },
          grid: {
              verticalLines: horizontal,
              horizontalLines: !horizontal
          }
      });
  })(document.getElementById("flotr5"));

  /******************/
  /* STACKED HORIZONTAL BARS
  /******************/

  (function flotr6(container, horizontal) {

      var
      d1 = [],
          d2 = [],
          d3 = [],
          graph, i;

      for (i = -10; i < 10; i++) {
          if (horizontal) {
              d1.push([Math.random(), i]);
              d2.push([Math.random(), i]);
              d3.push([Math.random(), i]);
          } else {
              d1.push([i, Math.random()]);
              d2.push([i, Math.random()]);
              d3.push([i, Math.random()]);
          }
      }

      graph = Flotr.draw(container, [{
          data: d1,
          label: 'Serie 1'
      }, {
          data: d2,
          label: 'Serie 2'
      }, {
          data: d3,
          label: 'Serie 3'
      }], {
          legend: {
              backgroundColor: '#D2E8FF' // Light blue 
          },
          bars: {
              show: true,
              stacked: true,
              horizontal: horizontal,
              barWidth: 0.6,
              lineWidth: 1,
              shadowSize: 0
          },
          grid: {
              verticalLines: horizontal,
              horizontalLines: !horizontal
          }
      });
  })(document.getElementById("flotr6"),true);

  /******************/
  /* BASIC PIE
  /******************/

  (function flotr7(container) {

      var
      d1 = [
          [0, 4]
      ],
          d2 = [
              [0, 3]
          ],
          d3 = [
              [0, 1.03]
          ],
          d4 = [
              [0, 3.5]
          ],
          graph;

      graph = Flotr.draw(container, [{
          data: d1,
          label: 'Comedy'
      }, {
          data: d2,
          label: 'Action'
      }, {
          data: d3,
          label: 'Romance',
          pie: {
              explode: 50
          }
      }, {
          data: d4,
          label: 'Drama'
      }], {
          HtmlText: false,
          grid: {
              verticalLines: false,
              horizontalLines: false
          },
          xaxis: {
              showLabels: false
          },
          yaxis: {
              showLabels: false
          },
          pie: {
              show: true,
              explode: 6
          },
          mouse: {
              track: true
          },
          legend: {
              position: 'se',
              backgroundColor: '#D2E8FF'
          }
      });
  })(document.getElementById("flotr7"));

  /******************/
  /* BASIC RADAR
  /******************/

  (function flotr8(container) {

      // Fill series s1 and s2.
      var
      s1 = {
          label: 'Actual',
          data: [
              [0, 3],
              [1, 8],
              [2, 5],
              [3, 5],
              [4, 3],
              [5, 9]
          ]
      },
          s2 = {
              label: 'Target',
              data: [
                  [0, 8],
                  [1, 7],
                  [2, 8],
                  [3, 2],
                  [4, 4],
                  [5, 7]
              ]
          },
          graph, ticks;

      // Radar Labels
      ticks = [
          [0, "Statutory"],
          [1, "External"],
          [2, "Videos"],
          [3, "Yippy"],
          [4, "Management"],
          [5, "oops"]
      ];

      // Draw the graph.
      graph = Flotr.draw(container, [s1, s2], {
          radar: {
              show: true
          },
          grid: {
              circular: true,
              minorHorizontalLines: true
          },
          yaxis: {
              min: 0,
              max: 10,
              minorTickFreq: 2
          },
          xaxis: {
              ticks: ticks
          }
      });
  })(document.getElementById("flotr8"));

  /******************/
  /* BASIC BUBBLE
  /******************/

  (function flotr9(container) {

      var
      d1 = [],
          d2 = [],
          point, graph, i;

      for (i = 0; i < 10; i++) {
          point = [i, Math.ceil(Math.random() * 10), Math.ceil(Math.random() * 10)];
          d1.push(point);

          point = [i, Math.ceil(Math.random() * 10), Math.ceil(Math.random() * 10)];
          d2.push(point);
      }

      // Draw the graph
      graph = Flotr.draw(container, [d1, d2], {
          bubbles: {
              show: true,
              baseRadius: 5
          },
          xaxis: {
              min: -4,
              max: 14
          },
          yaxis: {
              min: -4,
              max: 14
          }
      });
  })(document.getElementById("flotr9"));

  /******************/
  /* BASIC CANDLE
  /******************/

  (function flotr10(container) {

      var
      d1 = [],
          price = 3.206,
          graph, i, a, b, c;

      for (i = 0; i < 50; i++) {
          a = Math.random();
          b = Math.random();
          c = (Math.random() * (a + b)) - b;
          d1.push([i, price, price + a, price - b, price + c]);
          price = price + c;
      }

      // Graph
      graph = Flotr.draw(container, [d1], {
          candles: {
              show: true,
              candleWidth: 0.6
          },
          xaxis: {
              noTicks: 10
          }
      });
  })(document.getElementById("flotr10"));

  /******************/
  /* BASIC LEGEND
  /******************/

  (function flotr11(container) {

      var
      d1 = [],
          d2 = [],
          d3 = [],
          data, graph, i;

      // Data Generation
      for (i = 0; i < 15; i += 0.5) {
          d1.push([i, i + Math.sin(i + Math.PI)]);
          d2.push([i, i]);
          d3.push([i, 15 - Math.cos(i)]);
      }

      data = [{
          data: d1,
          label: 'x + sin(x+&pi;)'
      }, {
          data: d2,
          label: 'x'
      }, {
          data: d3,
          label: '15 - cos(x)'
      }];


      // This function prepend each label with 'y = '


      function labelFn(label) {
          return 'y = ' + label;
      }

      // Draw graph
      graph = Flotr.draw(container, data, {
          legend: {
              position: 'se',
              // Position the legend 'south-east'.
              labelFormatter: labelFn,
              // Format the labels.
              backgroundColor: '#D2E8FF' // A light blue background color.
          },
          HtmlText: false
      });
  })(document.getElementById("flotr11"));

  /******************/
  /* MOUSE TRACKING
  /******************/

  (function flotr12(container) {

      var
      d1 = [],
          d2 = [],
          d3 = [],
          graph, i;

      for (i = 0; i < 20; i += 0.5) {
          d1.push([i, 2 * i]);
          d2.push([i, i * 1.5 + 1.5 * Math.sin(i)]);
          d3.push([i, 3 * Math.cos(i) + 10]);
      }

      graph = Flotr.draw(
      container, [{
          data: d1,
          mouse: {
              track: false
          } // Disable mouse tracking for d1
      },
      d2, d3], {
          mouse: {
              track: true,
              // Enable mouse tracking
              lineColor: 'purple',
              relative: true,
              position: 'ne',
              sensibility: 1,
              trackDecimals: 2,
              trackFormatter: function(o) {
                  return 'x = ' + o.x + ', y = ' + o.y;
              }
          },
          crosshair: {
              mode: 'xy'
          }
      });

  })(document.getElementById("flotr12"));

  /******************/
  /* MOUSE ZOOM
  /******************/

  (function flotr13(container) {

      var
      d1 = [],
          d2 = [],
          d3 = [],
          options, graph, i;

      for (i = 0; i < 40; i += 0.5) {
          d1.push([i, Math.sin(i) + 3 * Math.cos(i)]);
          d2.push([i, Math.pow(1.1, i)]);
          d3.push([i, 40 - i + Math.random() * 10]);
      }

      options = {
          selection: {
              mode: 'x',
              fps: 30
          },
          title: 'Mouse Zoom'
      };

      // Draw graph with default options, overwriting with passed options


      function drawGraph(opts) {

          // Clone the options, so the 'options' variable always keeps intact.
          var o = Flotr._.extend(Flotr._.clone(options), opts || {});

          // Return a new graph.
          return Flotr.draw(
          container, [d1, d2, d3], o);
      }

      // Actually draw the graph.
      graph = drawGraph();

      // Hook into the 'flotr:select' event.
      Flotr.EventAdapter.observe(container, 'flotr:select', function(area) {

          // Draw graph with new area
          graph = drawGraph({
              xaxis: {
                  min: area.x1,
                  max: area.x2
              },
              yaxis: {
                  min: area.y1,
                  max: area.y2
              }
          });
      });

      // When graph is clicked, draw the graph with default area.
      Flotr.EventAdapter.observe(container, 'flotr:click', function() {
          drawGraph();
      });
  })(document.getElementById("flotr13"));

  /******************/
  /* MOUSE DRAG
  /******************/

  (function flotr14(container) {

      var
      d1 = [],
          d2 = [],
          d3 = [],
          options, graph, start, i;

      for (i = -40; i < 40; i += 0.5) {
          d1.push([i, Math.sin(i) + 3 * Math.cos(i)]);
          d2.push([i, Math.pow(1.1, i)]);
          d3.push([i, 40 - i + Math.random() * 10]);
      }

      options = {
          xaxis: {
              min: 0,
              max: 20
          },
          title: 'Mouse Drag'
      };

      // Draw graph with default options, overwriting with passed options


      function drawGraph(opts) {

          // Clone the options, so the 'options' variable always keeps intact.
          var o = Flotr._.extend(Flotr._.clone(options), opts || {});

          // Return a new graph.
          return Flotr.draw(
          container, [d1, d2, d3], o);
      }

      graph = drawGraph();

      function initializeDrag(e) {
          start = graph.getEventPosition(e);
          Flotr.EventAdapter.observe(document, 'mousemove', move);
          Flotr.EventAdapter.observe(document, 'mouseup', stopDrag);
      }

      function move(e) {
          var
          end = graph.getEventPosition(e),
              xaxis = graph.axes.x,
              offset = start.x - end.x;

          graph = drawGraph({
              xaxis: {
                  min: xaxis.min + offset,
                  max: xaxis.max + offset
              }
          });
          // @todo: refector initEvents in order not to remove other observed events
          Flotr.EventAdapter.observe(graph.overlay, 'mousedown', initializeDrag);
      }

      function stopDrag() {
          Flotr.EventAdapter.stopObserving(document, 'mousemove', move);
      }

      Flotr.EventAdapter.observe(graph.overlay, 'mousedown', initializeDrag);

  })(document.getElementById("flotr14"));

  /******************/
  /* TIME
  /******************/

  (function flotr15(container) {

      var
      d1 = [],
          start = new Date("2009/01/01 01:00").getTime(),
          options, graph, i, x, o;

      for (i = 0; i < 100; i++) {
          x = start + (i * 1000 * 3600 * 24 * 36.5);
          d1.push([x, i + Math.random() * 30 + Math.sin(i / 20 + Math.random() * 2) * 20 + Math.sin(i / 10 + Math.random()) * 10]);
      }

      options = {
          xaxis: {
              mode: 'time',
              labelsAngle: 45
          },
          selection: {
              mode: 'x'
          },
          HtmlText: false,
          title: 'Time'
      };

      // Draw graph with default options, overwriting with passed options


      function drawGraph(opts) {

          // Clone the options, so the 'options' variable always keeps intact.
          o = Flotr._.extend(Flotr._.clone(options), opts || {});

          // Return a new graph.
          return Flotr.draw(
          container, [d1], o);
      }

      graph = drawGraph();

      Flotr.EventAdapter.observe(container, 'flotr:select', function(area) {
          // Draw selected area
          graph = drawGraph({
              xaxis: {
                  min: area.x1,
                  max: area.x2,
                  mode: 'time',
                  labelsAngle: 45
              },
              yaxis: {
                  min: area.y1,
                  max: area.y2
              }
          });
      });

      // When graph is clicked, draw the graph with default area.
      Flotr.EventAdapter.observe(container, 'flotr:click', function() {
          graph = drawGraph();
      });
  })(document.getElementById("flotr15"));

  /******************/
  /* NEGATIVE VALUES
  /******************/

  (function flotr16(container) {

      var
      d0 = [],
          // Line through y = 0
          d1 = [],
          // Random data presented as a scatter plot. 
          d2 = [],
          // A regression line for the scatter. 
          sx = 0,
          sy = 0,
          sxy = 0,
          sxsq = 0,
          xmean, ymean, alpha, beta, n, x, y;

      for (n = 0; n < 20; n++) {

          x = n;
          y = x + Math.random() * 8 - 15;

          d0.push([x, 0]);
          d1.push([x, y]);

          // Computations used for regression line
          sx += x;
          sy += y;
          sxy += x * y;
          sxsq += Math.pow(x, 2);
      }

      xmean = sx / n;
      ymean = sy / n;
      beta = ((n * sxy) - (sx * sy)) / ((n * sxsq) - (Math.pow(sx, 2)));
      alpha = ymean - (beta * xmean);

      // Compute the regression line.
      for (n = 0; n < 20; n++) {
          d2.push([n, alpha + beta * n])
      }

      // Draw the graph
      graph = Flotr.draw(
      container, [{
          data: d0,
          shadowSize: 0,
          color: '#545454'
      }, // Horizontal
      {
          data: d1,
          label: 'y = x + (Math.random() * 8) - 15',
          points: {
              show: true
          }
      }, // Scatter
      {
          data: d2,
          label: 'y = ' + alpha.toFixed(2) + ' + ' + beta.toFixed(2) + '*x'
      } // Regression
      ], {
          legend: {
              position: 'se',
              backgroundColor: '#D2E8FF'
          },
          title: 'Negative Values'
      });
  })(document.getElementById("flotr16"));

  /******************/
  /* CLICK EXAMPLE
  /******************/

  (function flotr17(container) {

      var
      d1 = [
          [0, 0]
      ],
          // Point at origin
          options, graph;

      options = {
          xaxis: {
              min: 0,
              max: 15
          },
          yaxis: {
              min: 0,
              max: 15
          },
          lines: {
              show: true
          },
          points: {
              show: true
          },
          mouse: {
              track: true
          },
          title: 'Click Example'
      };

      graph = Flotr.draw(container, [d1], options);

      // Add a point to the series and redraw the graph
      Flotr.EventAdapter.observe(container, 'flotr:click', function(position) {

          // Add a point to the series at the location of the click
          d1.push([position.x, position.y]);

          // Sort the series.
          d1 = d1.sort(function(a, b) {
              return a[0] - b[0];
          });

          // Redraw the graph, with the new series.
          graph = Flotr.draw(container, [d1], options);
      });
  })(document.getElementById("flotr17"));

  /******************/
  /* BASIC TIMELINE
  /******************/

  (function flotr18(container) {

      var
      d1 = [
          [1, 4, 5]
      ],
          d2 = [
              [3.2, 3, 4]
          ],
          d3 = [
              [1.9, 2, 2],
              [5, 2, 3.3]
          ],
          d4 = [
              [1.55, 1, 9]
          ],
          d5 = [
              [5, 0, 2.3]
          ],
          data = [],
          timeline = {
              show: true,
              barWidth: .5
          },
          markers = [],
          labels = ['Obama', 'Bush', 'Clinton', 'Palin', 'McCain'],
          i, graph, point;

      // Timeline
      Flotr._.each([d1, d2, d3, d4, d5], function(d) {
          data.push({
              data: d,
              timeline: Flotr._.clone(timeline)
          });
      });

      // Markers
      Flotr._.each([d1, d2, d3, d4, d5], function(d) {
          point = d[0];
          markers.push([point[0], point[1]]);
      });
      data.push({
          data: markers,
          markers: {
              show: true,
              position: 'rm',
              fontSize: 11,
              labelFormatter: function(o) {
                  return labels[o.index];
              }
          }
      });

      // Draw Graph
      graph = Flotr.draw(container, data, {
          xaxis: {
              noTicks: 3,
              tickFormatter: function(x) {
                  var
                  x = parseInt(x),
                      months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
                  return months[(x - 1) % 12];
              }
          },
          yaxis: {
              showLabels: false
          },
          grid: {
              horizontalLines: false
          }
      });
  })(document.getElementById("flotr18"));
}
function redraw_analytics_chartjs(){
    //Get context with jQuery - using jQuery's .get() method.
    var ctx = $("#chartjs1").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var myNewChart = new Chart(ctx);
    var data =  {
            labels : ["Jan","Feb","Mar","Apr","May","June","July"],
            datasets : [
              {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                data : [65,59,90,81,56,55,40]
              },
              {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [28,48,40,19,96,27,100]
              }
            ]};
    new Chart(ctx).Line(data);

    //Get context with jQuery - using jQuery's .get() method.
    ctx = $("#chartjs2").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var myNewChart2 = new Chart(ctx);
    data = {
            labels : ["Jan","Feb","Mar","Apr","May","June","July"],
            datasets : [
              {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                data : [65,59,90,81,56,55,40]
              },
              {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                data : [28,48,40,19,96,27,100]
              }
            ]
          };
    new Chart(ctx).Bar(data);

    //Get context with jQuery - using jQuery's .get() method.
    ctx = $("#chartjs3").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var myNewChart3 = new Chart(ctx);
    data = {
            labels : ["Eating","Drinking","Sleeping","Designing","Coding","Partying","Running"],
            datasets : [
              {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                data : [65,59,90,81,56,55,40]
              },
              {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [28,48,40,19,96,27,100]
              }
            ]
          };
    new Chart(ctx).Radar(data);

    //Get context with jQuery - using jQuery's .get() method.
    ctx = $("#chartjs4").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var myNewChart4 = new Chart(ctx);
    data = [
            {
              value : 30,
              color: "#D97041"
            },
            {
              value : 90,
              color: "#C7604C"
            },
            {
              value : 24,
              color: "#21323D"
            },
            {
              value : 58,
              color: "#9D9B7F"
            },
            {
              value : 82,
              color: "#7D4F6D"
            },
            {
              value : 8,
              color: "#584A5E"
            }
          ];
    new Chart(ctx).PolarArea(data);

    //Get context with jQuery - using jQuery's .get() method.
    ctx = $("#chartjs5").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var myNewChart5 = new Chart(ctx);
    data = [
            {
              value: 30,
              color:"#F38630"
            },
            {
              value : 50,
              color : "#E0E4CC"
            },
            {
              value : 100,
              color : "#69D2E7"
            }     
          ];
    new Chart(ctx).Pie(data);

    //Get context with jQuery - using jQuery's .get() method.
    ctx = $("#chartjs6").get(0).getContext("2d");
    //This will get the first returned node in the jQuery collection.
    var myNewChart6 = new Chart(ctx);
    data = [{ value: 50, color:"#ceab3b"},{ value : 30, color : "#55bc75"},{ value : 100, color : "#dc4c42"}];
    new Chart(ctx).Doughnut(data);
}