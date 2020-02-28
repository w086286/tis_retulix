<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String ctx=request.getContextPath();
%>
<!--  오큘러스 재생 불가 -->

   
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>

<!-- css api js -->
<link rel = "stylesheet" href="./css/repage.css">
<script src="./js/api.js"></script>
<script src="./js/colResizable-1.6.min.js"></script>
<script src="./js/youtube.js"></script>

<script> 


	$(function(){
		 $('#play_movie').click(function(){
	            $('.iframe').slideDown(500,playYoutube());
	         
	        });
		 
	        var iframe = $('#players')[0];
	        var player = $(iframe);
		 
	        $('.imbt3').click(function(){
	              $('.iframe').slideUp(500,stopYoutube()); 
	       
	        });
	        
	});
	

 //////////////////////////////////////////////////////////////////////////////////////////////
 
         $(document).ready(function() {
        	 console.log("page on load")
        	
        	 var substr='${mvo.idx}';
        	 substr= substr.substring(0,1)
        	 /* 드라마 영화 판단후 각자 실행 */
        		 fetchMovie('${mvo.api_idx}',substr,function(result){
        	             $('.poster_img').attr("src",result[3]);
        	        	 $('.ma').html("<h1 style ='display:inline'>"+result[0]+"</h1>"+"<h3 style ='display:inline;color:gray'>("+result[5]+")</h3>");
        	        	 $('.ma').append("<h3>개요</h3>"+"<p>"+result[1]+"</p>");
        	        	 if(result[2]!='')
        	        		 {
        	        	 		$('.ma').append("감독 : "+result[2]);
        	        		
        	        		 }
        	             document.documentElement.style.setProperty('--main_bg', result[4]);
        	             }) 
        	             
        	       
        	   	
    	});
         function poster(pos,idxy){
        	 
        	 var str="";
        	 var img2="";
        	 var tmp=idxy.substring(0,1);
        		fetchMovie(pos,tmp,function(result){
	             	img2=result[3];
	             str='<a href='+"movieView.do?idx="+idxy+">"
	             str+='<img src='+img2+' width = "150px" height="100%">'
	             str+='</a>';
	           $('.rev').append(str);
	             })

         }
         function review_poster(furl,surl,index_num){
        	   var str='<a id = review'+index_num +' '+'onclick=overlay_show(this) title="'+furl+'">'
	              str+='<img src=https://img.youtube.com/vi/'+surl+'/mqdefault.jpg width = "300px" height="100%">'
	              str+='</a>'; 
	      	
	          $('.botom_reviews').append(str);
	   
	        
         }
  function overlay_show(event){
        	 var tmp=event.title
        	 $('#overlay').addClass('show')
             $('body').addClass("stop-scrolling");
        	var str= '<iframe id = "Overlay_players" src="'+tmp+'?controls=0&enablejsapi=1" width = "700px" height="450px"></iframe>'
        	$('.overtube').html(str);
         }


  function overlay_close(){
	  $('#overlay').removeClass('show')
      $('.overtube').html("");
      $('body').removeClass("stop-scrolling");
	  
  }
  
  function change_info_show(event){
 	 var tmp=event.title
 	 $('#change_info').addClass('show')
 	 $('.find_api').val(event);
      resize_able_table()
      $('body').addClass("stop-scrolling");
  }


function change_info_close(){
$('#change_info').removeClass('show')
$('body').removeClass("stop-scrolling");



}
 

	function send_ajax() {
		const key = "f6ef5ee7d41f7b86d5ea2c50796a6dfc";
		var name = $('.find_api').val();
		const url = "https://api.themoviedb.org/3/search/multi?api_key=" + key
				+ "&language=ko-KR&query=" + name + "&page=1"
		$.ajax({
			type : 'GET',
			url : url,
			dataType : 'json',
			cache : 'false',
			success : function(res) {
				var newArray = res.results;
				newArray.sort(function(a, b) {
					return b["vote_average"] - a["vote_average"];
				})
				showList(newArray);
			},
			error : function(e) {
				alert("e : " + e.status)
			}

		})

	}

	function showList(arr, tmp) {
		var str = ""
			$.each(arr, function(i, list) {
				if(list.media_type=='tv'){
					console.log(i)
				str += "<tr id=tmp"+i+"><td style='width:15%'>" + list.name + "</td>";
				str += "<td style='width:55%'>" + list.overview + "</td>";
				str += "<td style='width:20%'>" + list.first_air_date + "</td>";
				str += "<td style='width:15%'>" + list.original_name + "</td>";
				str += "</tr>";	
				}
				else
					{
					str += "<tr id=tmp"+i+"><td style='width:15%'>" + list.title + "</td>";
					str += "<td style='width:55%'>" + list.overview + "</td>";
					str += "<td style='width:20%'>" + list.release_date + "</td>";
					str += "<td style='width:15%'>" + list.original_title + "</td>";
					str += "</tr>";	
					
					}

			})

		
		$('#tables>tbody').html(str);
		

	}
	
	function resize_able_table(){
		
	   	$("#tables").colResizable({
	   	  fixed:false,
	      liveDrag:true
	     
		  });  
	}
	$(function(){
		
	$("#tmp0").click(function(){ 	
		alert("도;ㅁ");
		var str = ""
		var tdArr = new Array();	// 배열 선언
		
		// 현재 클릭된 Row(<tr>)
		var tr = $(this);
		var td = tr.children();
		
		// tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
		console.log("클릭한 Row의 모든 데이터 : "+tr.text());
		
		// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
		td.each(function(i){
			tdArr.push(td.eq(i).text());
		});
		alert(tdArr);
		console.log("배열에 담긴 값 : "+tdArr);
	
	});
	
		
	})
</script>



<!-- 리뷰어들 영상 오버레이 -->
<div id="overlay">
	<div class="overtube"></div>
	<div class='close'>
		<i onclick=overlay_close() class="far fa-times-circle"></i>
	</div>
</div>
<!-- api_idx재검색 -->
<div id="change_info">
	<div
		id="change_info_tab">
		<p>정보 수정 인터넷 검색</p>
		<i style="color: white" class="fas fa-search"></i>&nbsp;<input
			class="find_api" type="text">
		<button onclick="send_ajax()">검색</button>
		<br>
		<div id='tab'>
			<table class='tables' id='tables' >
			<thead>
				<tr class='success'>
					<th style='width: 15%'>타이틀</th>
					<th style='width: 55%'>요약</th>
					<th style='width: 20%'>개봉일</th>
					<th style='width: 15%'>원제목</th>
				</tr>
				</thead>
				<tbody>
				</tbody>
			</table>


		</div>
		<button>확인</button>
		<button onclick="change_info_close()">취소</button>
	</div>

</div>

<div class ="z_container">

	<div class='backgr' >
			<div class='fix_but' style="z-index:9;color:white"><i  onclick="change_info_show('${mvo.title}')" class="fas fa-wrench"></i></div>
		 	<div class="iframe" style="position:relative; display:none" >
			<iframe id ='players'src="${mvo.url}?controls=0&enablejsapi=1" width = "100%" height="600px"></iframe>
			
			<img class='imbt4' src="./images/exit2.png">
			<img class='imbt3' src="./images/exit.png"> 
			
			</div>
		<div class="container"  >
		
			<div class='item1'>
				<img class='poster_img'>
			 <i id="play_movie" class="fas fa-play"></i>
		</div>
			<div class="ma" style = "color : white;" >
				 <!--  본문-->
			</div>
			
		</div>

		<p></p>
		
		 <c:forEach var="pos" items="${arr}">
				 <script>
					poster('${pos.api_idx}','${pos.idx}');
				 </script>
		</c:forEach> 
		<h2 class ="text_head">관련 영상</h2>
		<div class="rev">
		</div>
		<p></p>
		
			<h2 class ="text_head">리뷰어 영상</h2>		
		<div class="botom_reviews">
			
		</div>
 <c:forEach var="review" items="${reviews}" varStatus="i">
				 <script>
				review_poster('${review.url}','${review.title}','${i.index}');
				 </script>
		</c:forEach> 
	</div>
	 </div>
