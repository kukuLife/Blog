
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
using System.Json;

namespace BlogFun
{
	[Activity (Label = "BlogListAdapter")]			
	public class BlogListAdapter : BaseAdapter
	{

		public List<Blog> blogs{ get; set;}
		Activity _activity;

		public BlogListAdapter(Activity activity, JsonValue jsonValue) {
			this._activity = activity;
			fillBlogs (jsonValue);
		}

		void fillBlogs(JsonValue jsonValue) {

			blogs = new List<Blog>();
            //foreach(var jsonEle in jsonValue) {
            //	int i = 1;
            //	Console.WriteLine ("bbbb" + jsonEle);
            //	Console.WriteLine ("bbbb" + jsonEle.ToString());
            //	i ++;
            //}

            //var rootObjects = Newtonsoft.Json.JsonConvert.DeserializeObject(jsonValue);
            //foreach(var rootObject in rootObjects) {
            //	int i = 1;
            //	blogs.Add (new Blog(i, rootObject.articleId, rootObject.articleName, rootObject.articleContent));
            //	i ++;
            //}

            //Console.WriteLine(rootObjects);

            int i = 1;
            foreach (var jsonEle in jsonValue)
            {
                var stringArray = jsonEle.ToString().Replace("{", "").Replace("}", "").Replace("\"", "").Replace(" ","").Split(',');
                var j = 1;
                String tempArticleId = "";
                String tempArticleName = "";
                String tempArticleContent = "";
                foreach(var stringEle in stringArray) {
                    var StringArray2 = stringEle.Split(':');
                    switch(j) {
                        case 1:
                            tempArticleId = StringArray2[1];
                        break;    
                        case 2:
                            tempArticleName = StringArray2[1];
                            break;
                        case 3:
                            tempArticleContent = StringArray2[1];
                            break;
                    }

                    j++;
                }
                blogs.Add(new Blog(i, tempArticleId, tempArticleName, tempArticleContent));
                i++;

            }
		}
			
		public class Blog {
			public Blog(long id,String articleId, String articleName, String articleContent) {
				this.id = id;
				this.articleId = articleId;
				this.articleName = articleName;
				this.articleContent = articleContent;
			}

			public long id { get; set;}
			public string articleId { get; set;}
			public string articleName { get; set;}
			public string articleContent { get; set;}
		}

		public override int Count {
			get { return blogs.Count; }
		}

		public override Java.Lang.Object GetItem (int position) {
			// could wrap a Contact in a Java.Lang.Object
			// to return it here if needed
			return null;
		}

		public override long GetItemId (int position) {
			return blogs [position].id;
		}

		public override View GetView (int position, View convertView, ViewGroup parent)
		{
			var view = convertView ?? _activity.LayoutInflater.Inflate (
				Resource.Layout.BlogDetail, parent, false);
			var articleId = view.FindViewById<TextView> (Resource.Id.BlogDetailId);
			var articleName = view.FindViewById<TextView> (Resource.Id.BlogDetailName);
			var articleContent = view.FindViewById<TextView> (Resource.Id.BlogDetailContent);

			articleId.Text = blogs [position].articleId;
			articleName.Text = blogs [position].articleName;
			articleContent.Text = blogs [position].articleContent;
			return view;
		}

	}
}

