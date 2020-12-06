$("#eye").click(function(){
	  var type = $("#haslo").attr("type");
	  if(type == 'password')
	  {
	  //alert("Wykonuje sie if" );
	  	$("#haslo").attr("type", "text");
	  }
	  else
	  {
	  	//alert("Wykonuje sie else");
	 	 $("#haslo").attr("type", "password"); 
	  }
  });

