//
//  Scene2ViewController.swift
//  FavoriteBooks
//
//  Created by Avra Saslow on 10/3/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var assignOneLabel: UITextField!
    @IBOutlet weak var assignTwoLabel: UITextField!
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneFavs" {
            let scene1ViewController = segue.destination as! ViewController
            if assignOneLabel.text!.isEmpty == false {
                scene1ViewController.user.assignOne = assignOneLabel.text
            }
            
            if assignTwoLabel.text!.isEmpty == false {
                scene1ViewController.user.assignTwo = assignTwoLabel.text
            }
        }
    }
    
    override func viewDidLoad() {
        assignOneLabel.delegate=self
        assignTwoLabel.delegate=self
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
