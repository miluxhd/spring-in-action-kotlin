package readinglistWithSecurity

import org.springframework.data.jpa.repository.JpaRepository


interface ReadingListRepository : JpaRepository<Book?, Long?> {
    fun findByReader(reader: Reader?): List<Book>?
}
