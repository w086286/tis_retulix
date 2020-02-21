<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String ctx=request.getContextPath();
%>
<!--  오큘러스 재생 불가 -->
<!DOCTYPE html>
<html lang="kr">
   
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<!-- css api js -->
<link rel = "stylesheet" type="text/css" href="./css/repage.css">
<script src="./js/api.js"></script>
<script> 


	$(function(){
		 $('.imbt1').click(function(){
	            $('.iframe').slideDown(500,playYoutube());
	         
	        });
		 
	        var iframe = $('#players')[0];
	        var player = $(iframe);
		 
	        $('.imbt3').click(function(){
	              $('.iframe').slideUp(500,stopYoutube()); 
	       
	        });
	        
	});
	
	//--------------------
        /**
         * Youtube API 로드
         */
        var tag = document.createElement('script');
        tag.src = "https://www.youtube.com/iframe_api";
        var firstScriptTag = document.getElementsByTagName('script')[0];
        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
 
        /**
         * onYouTubeIframeAPIReady 함수는 필수로 구현해야 한다.
         * 플레이어 API에 대한 JavaScript 다운로드 완료 시 API가 이 함수 호출한다.
         * 페이지 로드 시 표시할 플레이어 개체를 만들어야 한다.
         */
        var player;
        function onYouTubeIframeAPIReady() {
            player = new YT.Player('players', {
//                height: '315',            // <iframe> 태그 지정시 필요없음
//                width: '560',             // <iframe> 태그 지정시 필요없음
//                videoId: '9bZkp7q19f0',   // <iframe> 태그 지정시 필요없음
//                playerVars: {             // <iframe> 태그 지정시 필요없음
//                    controls: '2'
//                },
                events: {
                    'onReady': onPlayerReady,               // 플레이어 로드가 완료되고 API 호출을 받을 준비가 될 때마다 실행
                    'onStateChange': onPlayerStateChange    // 플레이어의 상태가 변경될 때마다 실행
                }
            });
        }
        function onPlayerReady(event) {
            console.log('onPlayerReady 실행');
 
            // 플레이어 자동실행 (주의: 모바일에서는 자동실행되지 않음)
            event.target.playVideo();
        }
        var playerState;
        function onPlayerStateChange(event) {
            playerState = event.data == YT.PlayerState.ENDED ? '종료됨' :
                    event.data == YT.PlayerState.PLAYING ? '재생 중' :
                    event.data == YT.PlayerState.PAUSED ? '일시중지 됨' :
                    event.data == YT.PlayerState.BUFFERING ? '버퍼링 중' :
                    event.data == YT.PlayerState.CUED ? '재생준비 완료됨' :
                    event.data == -1 ? '시작되지 않음' : '예외';
 
            console.log('onPlayerStateChange 실행: ' + playerState);
            // 재생여부를 통계로 쌓는다.
            collectPlayCount(event.data);
        }
        function playYoutube() {
            // 플레이어 자동실행 (주의: 모바일에서는 자동실행되지 않음)
            player.playVideo();
        }
        function pauseYoutube() {
            player.pauseVideo();
        }
        function stopYoutube() {
            player.seekTo(0, true);     // 영상의 시간을 0초로 이동시킨다.
            player.stopVideo();
        }
        var played = false;
        function collectPlayCount(data) {
            if (data == YT.PlayerState.PLAYING && played == false) {
                // todo statistics
                played = true;
                console.log('statistics');
            }
        }
 //////////////////////////////////////////////////////////////////////////////////////////////
 
         $(document).ready(function() {
        	 console.log("page on load")
        	
        	 var substr='${mvo.idx}';
        	 substr= substr.substring(0,1)
        	 /* 드라마 영화 판단후 각자 실행 */
        		 fetchMovie('${mvo.api_idx}',substr,function(result){
        	             $('.img').attr("src",result[3]);
        	        	 $('.ma').html("<h1 style ='display:inline'>"+result[0]+"</h1>"+"<h3 style ='display:inline;color:gray'>("+result[5]+")</h3>");
        	        	 $('.ma').append("<h3>개요</h3>"+result[1]);
        	        	 $('.ma').append("<br>감독 : "+result[2]);
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
	             str+='<img src='+ img2+' width = "150px" height="100%">'
	             str+='</a>';
	           $('.rev').append(str);
	             })
					
				
         }
     

</script>

<body>
<!-- js 함수 반복

	1. 지금한거 함수 1번을 5번 호출
 -->
	<div class='backgr' >
	
		 	<div class="iframe" style="position:relative; display:none " >
			<iframe id ='players'src="${mvo.url}?controls=0&enablejsapi=1" width = "100%" height="600px"  ></iframe>
			
			<img class='imbt4' src="./images/exit2.png">
			<img class='imbt3' src="./images/exit.png">
			
			</div>
		<div class="container"  >
		
			<div class='item1' style="border: 1px solid black">
				<img class='img'>
				<!--  포스터 -->
				
			<script>  
			
			</script>
				<div id="imgDiv">
				 
				<img class='imbt2' src="./images/재생over.png">
				<img class='imbt1' src="./images/재생.png">
				
				</div>
			</div>
			<div class="ma" style = "color : white" class='item2' > <!--  본문-->
				
				<%-- <c:out value="${mvo.api_idx}"/> --%>
	
			
			</div>

		</div>

		<p></p>
		
		 <c:forEach var="pos" items="${arr}">
				 <script>
					poster('${pos.api_idx}','${pos.idx}');
				 </script>
		</c:forEach> 
		<div class="rev">
		
			
		</div>
		<p></p>
		<div class="bot">

			<div>6</div>
			<div>7</div>
			<div>8</div>
			<div>9</div>
			<div>10</div>
		</div>

	</div>
</body>

</html>