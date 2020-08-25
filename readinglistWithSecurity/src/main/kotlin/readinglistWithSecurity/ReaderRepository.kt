package readinglistWithSecurity

import org.springframework.data.jpa.repository.JpaRepository

interface ReaderRepository : JpaRepository<Reader?, String?>{

}
