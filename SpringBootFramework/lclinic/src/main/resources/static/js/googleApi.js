const CLIENT_ID = "238259988461-qljnehpllccpr7rlisv1fogc17ecm3me.apps.googleusercontent.com";
const REDIRECT_URI = "http://localhost:7777/login/oauth/google";

onload = () => {
	document.querySelector('#btn-google').onclick = () => {
		alert("구글 로그인!");
		const url = "https://accounts.google.com/o/oauth2/v2/auth"
					+ "?client_id=" + CLIENT_ID
					+ "&redirect_uri=" + REDIRECT_URI
					+ "&response_type=code"
					+ "&scope=email profile";
					
		location.href = url;
	};
}