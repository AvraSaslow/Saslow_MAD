//
//  ViewController.swift
//  FavoriteBooks
//
//  Created by Avra Saslow on 10/20/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var aOne: UILabel!
    @IBOutlet weak var aTwo: UILabel!
    
    var user = School()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


    @IBAction func unwindSegue(_ segue:UIStoryboardSegue){
        aOne.text=user.assignOne
        aTwo.text=user.assignTwo
    }
}

