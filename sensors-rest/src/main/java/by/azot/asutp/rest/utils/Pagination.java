package by.azot.asutp.rest.utils;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Add my own pagination to my list of different objects
 *
 * @param <T>
 */
public class Pagination<T> {

    ModelAndView modelAndView;

    public Pagination(List<T> objectList, int page, int maxRecordPerPage, ModelAndView modelAndView) {
        int lastPage = (int) Math.ceil((double) objectList.size() / (double) maxRecordPerPage);

        if (objectList.size() >= maxRecordPerPage) {
            if (objectList.size() < page * maxRecordPerPage) page = lastPage;
            int lastRecord = page * maxRecordPerPage;
            lastRecord = lastRecord > objectList.size() ? objectList.size() : lastRecord;
            objectList = objectList.subList((page - 1) * maxRecordPerPage, lastRecord);
        }

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
