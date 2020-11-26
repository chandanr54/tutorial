$(document).ready(function(){
	
	var a=0;
	var b=0;
	var c=0;
	$("#like").click(function(){
		$("#h5").text(++a);
	});
	
	$("#dlike").click(function(){
		$("#dl").text(++b);
	});
	
	$("#b1").click(function(){
		$("#co").text(++c);
		
	});
	
	$("#c1").click(function(){
		
		  $("#com").toggle();
	});
	
	
	
	$('#b1').click( function( e ) { 
		 var str=$("#usr").val();
		 e.preventDefault();
		 $('<div/>').addClass( 'new-text-div' ) .html( $('<label></label>').addClass( 'someclass' ) ) .append( $('<button/>').addClass( 'remove' ).text( 'Remove Post' ) ) .insertAfter("#usr"); 
		 
		 $(".someclass").text(str);
		 
			
		 
		 } );
	 
	$(document).on('click', 'button.remove', function( e ) { e.preventDefault(); $(this).closest( 'div.new-text-div' ).remove();
	$("#co").text(--c);
	});
		 
	
	
});