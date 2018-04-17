
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace BlogFun
{
	[Activity (Label = "BlogDetailActivity")]			
	public class BlogDetailActivity : Activity
	{

		TextView articleIdText;
		TextView articleNameText;
		TextView articleContentText;


		protected override void OnCreate (Bundle savedInstanceState)
		{
			base.OnCreate (savedInstanceState);

			SetContentView (Resource.Layout.BlogEditor);

			var articleId = Intent.GetStringExtra ("articleId") ?? "Data not available";
			var articleName = Intent.GetStringExtra ("articleName") ?? "Data not available";
			var articleContent = Intent.GetStringExtra ("articleContent") ?? "Data not available";

			articleIdText = FindViewById<TextView> (Resource.Id.articleId);
			articleNameText = FindViewById<TextView> (Resource.Id.articleName);
			articleContentText = FindViewById<TextView> (Resource.Id.articleContent);
			var articleButton = FindViewById<Button> (Resource.Id.articleButton);

			articleIdText.Text = articleId;
			articleNameText.Text = articleName;
			articleContentText.Text = articleContent;

			articleButton.Click += updateArticle;
		}

		void updateArticle(object sender, EventArgs args) {
		
			string url = "http://10.0.2.2:8080/Blog/updateBlogDetail.action?articleId=" +articleIdText.Text + "&articleTitle=" + articleNameText.Text + "&articleContent=" + articleContentText.Text;
			System.Net.HttpWebRequest request = (System.Net.HttpWebRequest)System.Net.HttpWebRequest.Create (new Uri (url));
			request.Method = "POST";
			request.UserAgent = "userAgent";

			using (System.Net.WebResponse response = request.GetResponse ()) {
				using (System.IO.Stream stream = response.GetResponseStream ()) {
					Console.WriteLine("fff", stream);
				}
			}
				
			var intent = new Android.Content.Intent(this, typeof(BlogListActivity));
			StartActivity(intent);
		}

	}
}

