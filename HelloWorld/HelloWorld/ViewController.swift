//
//  ViewController.swift
//  HelloWorld
//
//  Created by Avra Saslow on 8/29/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var MessegeText: UILabel!
    
    @IBAction func ButtonPressed(_ sender: UIButton) {
        MessegeText.text="FerdaBoiz"
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

