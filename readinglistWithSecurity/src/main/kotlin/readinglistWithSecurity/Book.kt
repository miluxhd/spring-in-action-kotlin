package readinglistWithSecurity

import javax.persistence.*


@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @ManyToOne
    var reader: Reader? = null
    var isbn: String? = null
    var title: String? = null
    var author: String? = null
    var description: String? = null

}
