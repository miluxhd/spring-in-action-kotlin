package readinglistWithSecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@Controller
@RequestMapping("/")
class ReadingListController @Autowired constructor(private val readingListRepository: ReadingListRepository,
                                                   private val amazonConfig: AmazonProperties) {
    @RequestMapping(method = [RequestMethod.GET])
    fun readersBooks(reader: Reader?, model: Model): String {
        val readingList = readingListRepository.findByReader(reader)
        if (readingList != null) {
            model.addAttribute("books", readingList)
            model.addAttribute("reader", Reader())
            model.addAttribute("amazonID", amazonConfig.associateId)
        }
        return "readingList"
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun addToReadingList(reader: Reader?, book: Book): String {
        book.reader = reader
        readingListRepository.save(book)
        return "redirect:/"
    }

}
