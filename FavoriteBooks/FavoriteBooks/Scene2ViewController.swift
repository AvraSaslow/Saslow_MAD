//
//  Scene2ViewController.swift
//  FavoriteBooks
//
//  Created by Avra Saslow on 10/3/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var userBook: UITextField!
    @IBOutlet weak var userAuthor: UITextField!
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneFavs" {
            let scene1ViewController = segue.destination as! ViewController
            if userBook.text!.isEmpty == false {
                scene1ViewController.user.favBook = userBook.text
            }
            
            if userAuthor.text!.isEmpty == false {
                scene1ViewController.user.favAuthor = userAuthor.text 
            }
        }
    }
    
    override func viewDidLoad() {
        userBook.delegate=self
        userAuthor.delegate=self
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
