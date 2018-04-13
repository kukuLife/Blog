//
//  BlogDetail.swift
//  Blog
//
//  Created by 生活酷 on 06/03/2018.
//  Copyright © 2018 生活酷. All rights reserved.
//

import UIKit

class BlogDetailController: UIViewController {
    
    @IBOutlet weak var articleId: UITextField!
    
    @IBOutlet weak var articleTitle: UITextField!
    
    @IBOutlet weak var articleContent: UITextView!
    
    var articleIdText:String?
    
    var articleTitleText:String?
    
    var articleContentText:String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.navigationItem.title = "blogDetail"
        articleId.text = articleIdText;
        articleTitle.text = articleTitleText;
        articleContent.text = articleContentText;
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func updateArticle(_ sender: Any) {
        let url:URL! = URL(string: "http://localhost:8080/Blog/updateBlogDetail.action?articleId=" + articleId.text! + "&articleTitle=" + articleTitle.text! + "&articleContent=" + articleContent.text!);
        
        let urlRequest:URLRequest = URLRequest(url: url, cachePolicy: .useProtocolCachePolicy, timeoutInterval: 10);
        
        var response:URLResponse?;
        
        do {
            
            let received =  try NSURLConnection.sendSynchronousRequest(urlRequest, returning: &response)
        

            let storyBoard : UIStoryboard = UIStoryboard(name: "Main", bundle:nil)

            let nextViewController = storyBoard.instantiateViewController(withIdentifier: "BlogListController") as! BlogListController
            self.present(nextViewController, animated:true, completion:nil)
        } catch let error{
            print(error.localizedDescription);
        }
    }
}
