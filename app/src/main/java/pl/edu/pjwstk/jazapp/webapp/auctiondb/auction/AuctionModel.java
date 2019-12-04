package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo.PhotoEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AuctionModel {
    @Inject
    AuctionRepository auctionRepository;
    @Inject
    AuctionRequest auctionRequest;

    public void create() {
        auctionRepository.create(auctionRequest.getDescription(), auctionRequest.getSectionId(), auctionRequest.getPrice());
    }

    public void edit() {
        System.out.println("AuctionRequest.id: " + auctionRequest.getId() + " <------------------------------------------------------------------------------------------------------------------------------");
        auctionRepository.edit(auctionRequest.getId(), auctionRequest.getDescription(), auctionRequest.getSectionId(), auctionRequest.getPrice());
    }

    public void edit(int id) {
        System.out.println("AuctionModel id: " + id + " <---------------------------------------------------------------------------------------------------------------------------------------------------");
        auctionRepository.edit(id, auctionRequest.getDescription(), auctionRequest.getSectionId(), auctionRequest.getPrice());
    }

    public String editDescription() {
        auctionRepository.editDescription(auctionRequest.getId(), auctionRequest.getDescription());
        return "myauctions";
    }

    public String editDescription(int id) {
        System.out.println("AuctionModel id: " + id + " <---------------------------------------------------------------------------------------------------------------------------------------------------");
        auctionRepository.editDescription(id, auctionRequest.getDescription());

    }

    public void editSection() {
        auctionRepository.editSection(auctionRequest.getId(), auctionRequest.getSectionId());
    }

    public void editSection(int id) {
        auctionRepository.editSection(id, auctionRequest.getSectionId());
    }

    public void editPrice() {
        auctionRepository.editPrice(auctionRequest.getId(), auctionRequest.getPrice());
    }

    public void editPrice(int id) {
        auctionRepository.editPrice(id, auctionRequest.getPrice());
    }

    public String editPhoto() {
        return "auction_edit.xhtml";
    }

    public List<PhotoEntity> findPhotosByAuctionId() {
        //String strzalka = " <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        if (!(auctionRequest.getId() == 0)) {
            //System.out.println("Id jest prawidlowe: " + auctionRequest.getId() + strzalka);
            var list = auctionRepository.findPhotosByAuctionId(auctionRequest.getId());

            if (list.isEmpty()) {
                //System.out.println("Ale lista jest pusta :(" + strzalka);
                PhotoEntity photoEntity = new PhotoEntity("https://www.computerhope.com/jargon/e/error.gif");
                list.add(photoEntity);
                return list;
            } else {
                //System.out.println("I zwracam liste, bo tam cos jest :)" + strzalka);
                return list;
            }
        } else {
            //System.out.println("Id jest ZLE!!!: " + auctionRequest.getId() + strzalka);
            var list = new AuctionEntity().getPhotoEntityList();
            PhotoEntity photoEntity = new PhotoEntity("https://www.computerhope.com/jargon/e/error.gif");
            list.add(photoEntity);
            return list;
        }
    }
}
