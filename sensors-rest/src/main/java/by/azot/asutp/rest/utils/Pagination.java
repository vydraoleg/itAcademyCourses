package by.azot.asutp.rest.utils;

import by.azot.asutp.rest.api.IControllerUrl;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Add my own pagination to my list of different objects
 *
 * @param <T>
 */
public class Pagination<T> implements IControllerUrl {

    ModelAndView modelAndView;

    public Pagination(List<T> objectList, int page, String nameListObject, ModelAndView modelAndView) {

        int lastPage = (int) Math.ceil((double) objectList.size() / (double) MAXRECORDPERPAGE);

        if (objectList.size() >= MAXRECORDPERPAGE) {
            if (objectList.size() < page * MAXRECORDPERPAGE) page = lastPage;
            int lastRecord = page * MAXRECORDPERPAGE;
            lastRecord = lastRecord > objectList.size() ? objectList.size() : lastRecord;
            objectList = objectList.subList((page - 1) * MAXRECORDPERPAGE, lastRecord);
        }
        modelAndView.addObject(nameListObject, objectList);

        modelAndView.addObject("prevPage", page <= 1 ? 1 : page - 1);
        modelAndView.addObject("page", page);
        modelAndView.addObject("nextPage", page < lastPage ? page + 1 : lastPage);
        modelAndView.addObject("lastPage", lastPage);
        this.modelAndView = modelAndView;
    }

    public ModelAndView getModelAndView() {
        return this.modelAndView;
    }
}
