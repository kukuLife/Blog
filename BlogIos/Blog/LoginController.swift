//
//  ViewController.swift
//  Blog
//
//  Created by 生活酷 on 04/03/2018.
//  Copyright © 2018 生活酷. All rights reserved.
//

import UIKit

class LoginController: UIViewController {
    @IBOutlet weak var userName: UITextField!
    @IBOutlet weak var passWord: UITextField!
    @IBAction func login(_ sender: Any) {
        NSLog(userName.text! + passWord.text!);
        let url:URL! = URL(string: "http://localhost:8080/Blog/loginFromApp.action?userName=" + userName.text! + "&passWord=" + passWord.text!);
        let urlRequest:URLRequest = URLRequest(url: url, cachePolicy: .useProtocolCachePolicy, timeoutInterval: 10)
        // 3、响应对象
        var response:URLResponse?
        // 4、发出请求
        do {
            let received =  try NSURLConnection.sendSynchronousRequest(urlRequest, returning: &response)
            let jsonStr = String(data: received, encoding:String.Encoding.utf8);
            print(jsonStr as Any)
            
            if("true" == jsonStr) {
                let storyBoard : UIStoryboard = UIStoryboard(name: "Main", bundle:nil)
                
                let nextViewController = storyBoard.instantiateViewController(withIdentifier: "BlogListController") as! BlogListController
                self.present(nextViewController, animated:true, completion:nil)
            } else {
                let alertController = UIAlertController(title: "wrong password", message:
                    "userName or passWord is wrong", preferredStyle: UIAlertControllerStyle.alert)
                alertController.addAction(UIAlertAction(title: "cancel", style: UIAlertActionStyle.default,handler: nil))
                
                self.present(alertController, animated: true, completion: nil)
            }
        } catch let error{
            print(error.localizedDescription);
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}

