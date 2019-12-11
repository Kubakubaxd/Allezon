package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionModel {
    @Inject
    AuctionRepository auctionRepository;
    @Inject
    AuctionRequest req;

    public String create() {
        auctionRepository.create(req.getDescription(), req.getSectionId(), req.getPrice());
        return "myauctionsowner";
    }

    public String edit() {
        auctionRepository.edit(req.getId(), req.getDescription(), req.getSectionId(), req.getPrice());
        return "myauctionsowner";
    }

    public String editDescription() {
        auctionRepository.editDescription(req.getId(), req.getDescription());
        return "myauctionsowner";
    }

    public String editSection() {
        auctionRepository.editSection(req.getId(), req.getSectionId());
        return "myauctionsowner";
    }

    public String editPrice() {
        auctionRepository.editPrice(req.getId(), req.getPrice());
        return "myauctionsowner";
    }

//    public List<PhotoEntity> findPhotosByAuctionId() {
//        if (!(req.getId() == 0)) {
//            //System.out.println("Id jest prawidlowe: " + auctionRequest.getId() + strzalka);
//            var list = auctionRepository.findPhotosByAuctionId(req.getId());
//
//            if (list.isEmpty()) {
//                //System.out.println("Ale lista jest pusta :(" + strzalka);
//                PhotoEntity photoEntity = new PhotoEntity("https://www.computerhope.com/jargon/e/error.gif");
//                list.add(photoEntity);
//                return list;
//            } else {
//                //System.out.println("I zwracam liste, bo tam cos jest :)" + strzalka);
//                return list;
//            }
//        } else {
//            //System.out.println("Id jest ZLE!!!: " + auctionRequest.getId() + strzalka);
//            var list = new AuctionEntity().getPhotoEntityList();
//            PhotoEntity photoEntity = new PhotoEntity("https://www.computerhope.com/jargon/e/error.gif");
//            list.add(photoEntity);
//            return list;
//        }
//    }
}
