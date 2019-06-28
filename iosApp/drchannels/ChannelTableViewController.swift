//
//  ChannelTableViewController.swift
//  drapi-test
//
//  Created by Claus Holst on 24/12/2018.
//  Copyright © 2018 Claus Holst. All rights reserved.
//

import UIKit
import AVKit
import AVFoundation
import drapi

class ChannelTableViewController: UITableViewController {

    var channels = [MuNowNext]()
    
    lazy var repo: DrMuRepositoryCallback = {
        DrMuRepositoryCallback()
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadChannels()
    }
    
    //MARK: Private Methods
    
    private func loadChannels() {
        repo.getScheduleNowNext(callback: {
            (schedules: [MuNowNext]) -> Void in
            print("Got channels result")
            self.channels = schedules.filter({ (nowNext: MuNowNext) -> Bool in
                nowNext.Now != nil
            })
            self.tableView.reloadData()
        })
    }
    
    func playVideo(uri: String) {
        
        guard let url = URL(string: uri) else {
            return
        }
        
        // Create an AVPlayer, passing it the HTTP Live Streaming URL.
        let player = AVPlayer(url: url)
        
        // Create a new AVPlayerViewController and pass it a reference to the player.
        let controller = AVPlayerViewController()
        controller.player = player
        
        // Modally present the player and call the player's play() method when complete.
        present(controller, animated: true) {
            player.play()
        }
    }


    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let name = self.channels[indexPath.row].ChannelSlug
        
        repo.getAllActiveDrTvChannels(callback: {
            (channels: [Channel]) -> Void in
            
            let channel = channels.first(where: { (channel: Channel) -> Bool in
                channel.Slug == name
            })
            
            let server = channel?.server()
            let stream = server?.Qualities.first?.Streams.first?.Stream
            let url = "\(server!.Server)/\(stream!)"
            
            print("Playing url: \(url)")
            
            self.playVideo(uri: url)
        })
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.channels.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "ChannelTableViewCell", for: indexPath) as? ChannelTableViewCell else {
            fatalError("The dequeued cell is not an instance of ChannelTableViewCell.")
        }

        let channel = channels[indexPath.row]
        let imageUri = channel.Now?.ProgramCard.PrimaryImageUri ?? ""
        
        cell.titleLabel.text = channel.Now?.Title ?? "Unknown title"
        cell.descriptionLabel.text = channel.Now?.Subtitle ?? "Unknown description"
        cell.channelImageView.load(url: URL.init(string: imageUri)!, tableView: self.tableView)

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
