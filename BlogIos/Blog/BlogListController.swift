//
//  BlogListController.swift
//  Blog
//
//  Created by 生活酷 on 06/03/2018.
//  Copyright © 2018 生活酷. All rights reserved.
//

import UIKit

class ArticleTableViewCell: UITableViewCell{
    
    @IBOutlet weak var articleId: UILabel!
    
    @IBOutlet weak var articleTitle: UILabel!
    
    @IBOutlet weak var articleContent: UILabel!
    
}

class ArticleContentView: UIView {
    
}

class BlogListController: UITableViewController {

    var articles = [Article]();

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let url:URL! = URL(string: "http://localhost:8080/Blog/blogListInfo.action");
        
        let urlRequest:URLRequest = URLRequest(url: url, cachePolicy: .useProtocolCachePolicy, timeoutInterval: 10)
        
        // 3、响应对象
        var response:URLResponse?
        
        // 4、发出请求
        do {
            
            let received =  try NSURLConnection.sendSynchronousRequest(urlRequest, returning: &response)
            let dic = try JSONSerialization.jsonObject(with: received, options: JSONSerialization.ReadingOptions.allowFragments)
            print(dic)
            
            for tempDic in dic as! [Dictionary<String, AnyObject>] {
                let articleId = tempDic["articleId"] as! String;
                let articleTitle = tempDic["title"] as! String;
                let articleContent = tempDic["content"] as! String;
            
                let article = Article(articleId: articleId, articleTitle:articleTitle, articleContent:articleContent)
                articles.append(article)
            }
            self.tableView.reloadData()
        } catch let error{
            print(error.localizedDescription);
        }
    }
    
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) ->Int {
        return articles.count;
    }
    
    var valueToPassArticleId:String!;
    var valueToPassArticleTitle:String!;
    var valueToPassArticleContent:String!;
    
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "articleCell", for: indexPath as IndexPath)as! ArticleTableViewCell
        let article = articles[indexPath.row]
        cell.articleId?.text = article.articleId
        cell.articleTitle?.text = article.articleTitle
        cell.articleContent?.text = article.articleContent
        cell.textLabel?.text = "article info";
        valueToPassArticleId = article.articleId;
        valueToPassArticleTitle = article.articleTitle;
        valueToPassArticleContent = article.articleContent;
        return cell
    }
    
    override func viewWillAppear(_ animated: Bool) {
        navigationItem.title = "ArticleInfo"
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "blogEditerSegue") {
            let viewController = segue.destination as! BlogDetailController
            viewController.articleIdText = valueToPassArticleId;
            viewController.articleTitleText = valueToPassArticleTitle;
            viewController.articleContentText = valueToPassArticleContent;

        }
    }
    

}
