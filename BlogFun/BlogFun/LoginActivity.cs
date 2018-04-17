using Android.App;
using Android.Widget;
using Android.OS;
using Android.Content;
using System;
using System.Net;
using System.IO;


namespace BlogFun
{
	[Activity (Label = "BlogFun", MainLauncher = true, Icon = "@mipmap/icon")]
	public class LoginActivity : Activity

		

	{
		public static HttpWebRequest request;

		protected override void OnCreate(Bundle bundle) {
			base.OnCreate (bundle);
			SetContentView (Resource.Layout.Login);
		
			EditText userName = FindViewById<EditText> (Resource.Id.userNameText);
			EditText passWord = FindViewById<EditText> (Resource.Id.passWordText);

			Button loginButton = FindViewById<Button> (Resource.Id.LoginButton);

			loginButton.Click += async (sender, e) => {
				string url = "http://10.0.2.2:8080/Blog/loginFromApp.action?userName=" + userName.Text + "&passWord=" + passWord.Text;
				String checkResult = checkUserInfo(url);
				if(checkResult == "true") {
					var intent = new Android.Content.Intent(this, typeof(BlogListActivity));
					StartActivity(intent);

				} else {
					Console.WriteLine ("cc" + checkResult);
					string message = "wrong userId or passWord";
					Toast.MakeText(ApplicationContext, message, ToastLength.Long).Show();
				}


			};
		}

		private String checkUserInfo(string url) {
			LoginActivity.request = (HttpWebRequest)HttpWebRequest.Create (new Uri (url));
			request.ContentType = "text/xml";
			request.Method = "GET";

			using (WebResponse response = request.GetResponse ()) {
				using (System.IO.Stream stream = response.GetResponseStream()) {
					if(stream != null) {
						var reader = new StreamReader (stream);
						String receiveContent = reader.ReadToEnd ();
						reader.Close ();
						return receiveContent;
					}

					return "fuck";
				}	
			}
		}

	}
}


