//
//  ChannelTableViewController.swift
//  drapi-test
//
//  Created by Claus Holst on 24/12/2018.
//  Copyright © 2018 Claus Holst. All rights reserved.
//

import UIKit
import drapi_lib

class ChannelTableViewController: UITableViewController {

    var channels = [MuNowNext]()
    
    lazy var repo: DrMuRepositoryCallback = {
        DrMuRepositoryCallback(
            coroutineContext: UI() as! KotlinCoroutineContext)
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        loadChannels()
    }
    
    //MARK: Private Methods
    
    private func loadChannels() {
        repo.getScheduleNowNext(callback: {
            (schedules: [MuNowNext]) -> KotlinUnit in
            print("Got channels result")
            for nowNext in schedules {
                print(nowNext.now?.title, "starts at", nowNext.now?.announcedStartTime)
                print(nowNext.next.first?.title, "starts at", nowNext.next.first?.announcedStartTime)
            }
            self.channels = schedules
            
            self.tableView.reloadData()
            return KotlinUnit.init()
        })
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return self.channels.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "ChannelTableViewCell", for: indexPath) as? ChannelTableViewCell else {
            fatalError("The dequeued cell is not an instance of ChannelTableViewCell.")
        }

        let channel = channels[indexPath.row]
        
        cell.titleLabel.text = channel.now?.title ?? "Unknown title"
        cell.descriptionLabel.text = channel.now?.subtitle ?? "Unknown description"
        cell.channelImageView.load(url: URL.init(string: channel.now?.programCard.primaryImageUri ?? "")!, tableView: self.tableView)

        return cell
    }

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}

extension UIImageView {
    func load(url: URL, tableView: UITableView) {
        DispatchQueue.global().async { [weak self] in
            if let data = try? Data(contentsOf: url) {
                if let image = UIImage(data: data) {
                    DispatchQueue.main.async {
                        self?.image = image
                        tableView.reloadData()
                    }
                }
            }
        }
    }
}
