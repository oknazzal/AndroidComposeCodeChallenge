package com.qpros.codechallenge
import com.qpros.codechallenge.data.datasource.main.RemoteNewsDataSource
import com.qpros.codechallenge.data.model.main.RemoteNewsResponse
import com.qpros.codechallenge.data.repo.NewsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryTest {

    @Mock
    private lateinit var remoteNewsDataSource: RemoteNewsDataSource

    private lateinit var newsRepository: NewsRepository

    @Test
    fun `getNews returns expected news`() = runTest {
        val expectedNews = listOf(
            RemoteNewsResponse(
                author = "Test Author 1",
                title = "Test Title 1",
                description = "Test Description 1",
                url = "https://testurl1.com",
                urlToImage = "https://testurl1.com/image1.jpg",
                content = "Test Content 1",
                publishedAt = "2023-07-27T12:00:00Z"
            ),
            RemoteNewsResponse(
                author = "Test Author 2",
                title = "Test Title 2",
                description = "Test Description 2",
                url = "https://testurl2.com",
                urlToImage = "https://testurl2.com/image2.jpg",
                content = "Test Content 2",
                publishedAt = "2023-07-27T13:00:00Z"
            ))

        `when`(remoteNewsDataSource.getNews()).thenReturn(expectedNews)

        newsRepository = NewsRepository(remoteNewsDataSource)

        // Act
        val result = newsRepository.getNews()

        // Assert
        assertEquals(expectedNews, result)
    }
}