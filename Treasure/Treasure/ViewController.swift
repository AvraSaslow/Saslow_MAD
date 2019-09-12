//
//  ViewController.swift
//  Treasure
//
//  Created by Avra Saslow on 9/11/19.
//  Copyright © 2019 Avra Saslow. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var Fenn: UIButton!
    
    //fenn button
    @IBAction func FennButton(_ sender: UIButton) {
    }
    
    
    @IBOutlet weak var CluesText: UITextView!
    
    //clues button
    @IBAction func Clues(_ sender: UIButton) {
        CluesText.text="Where Warm Waters Halt is believed by many to be the KEY clue to solving the puzzle.  Especially considering the usage of the phrase ‘begin it’ immediately preceding. We could be looking for any type of hot spring of thermal feature (like an of the billions of ones in Yellowstone and the rest of the rocky mountains).A location with a name that’s a combination of ‘hot/warm/temperature’ & ‘waters/liquid/body-of-water’ & ‘halt/end/stop/finish’."
    }
    
    
   
    //map button
    @IBAction func Map(_ sender: UIButton) {
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

