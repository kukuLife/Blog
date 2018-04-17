
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Json;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace BlogFun
{
	[Activity (Label = "BlogListActivity")]			
	public class BlogListActivity : ListActivity
	{

		BlogListAdapter blogListAdapter;

		protected override void OnCreate (Bundle savedInstanceState)
		{
			base.OnCreate (savedInstanceState);

			SetContentView (Resource.Layout.BlogList);


			string url = "http://10.0.2.2:8080/Blog/blogListInfo.action";
			System.Net.HttpWebRequest request = (System.Net.HttpWebRequest)System.Net.HttpWebRequest.Create (new Uri (url));
			request.Method = "GET";
			request.UserAgent = "userAgent";
			using (System.Net.WebResponse response = request.GetResponse ()) {
				using (System.IO.Stream stream = response.GetResponseStream ()) {
					Console.WriteLine("ddd", stream);
					// Use this stream to build a JSON document object:
					JsonValue jsonDoc = JsonObject.Load(stream);
					Console.WriteLine("Response: {0}", jsonDoc.ToString());
				
					blogListAdapter =  new BlogListAdapter(this, jsonDoc);	
					var blogListView = FindViewById<ListView> (Android.Resource.Id.List);
					blogListView.Adapter = blogListAdapter;
				
				}
			}
		}
			
		protected override void OnListItemClick (ListView l, View v, int position, long id)
		{
			string message = " articleId " + blogListAdapter.blogs[position].articleId + "  articleName  " + blogListAdapter.blogs[position].articleName + "  articleContent  " + blogListAdapter.blogs[position].articleContent;
			Toast.MakeText(ApplicationContext, message, ToastLength.Long).Show();
			var blogDetailActivity = new Intent (this, typeof(BlogDetailActivity));
			blogDetailActivity.PutExtra ("articleId", blogListAdapter.blogs[position].articleId);
			blogDetailActivity.PutExtra ("articleName", blogListAdapter.blogs[position].articleName);
			blogDetailActivity.PutExtra ("articleContent", blogListAdapter.blogs[position].articleContent);
			StartActivity (blogDetailActivity);
		}     
	}
}

