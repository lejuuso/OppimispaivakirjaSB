package fi.academy.opaivakirja;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "topic_topic_id_seq")
    @SequenceGenerator(name = "topic_topic_id_seq",sequenceName = "topic_topic_id_seq",allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(nullable = false)
    private String topic;
    private String description;
    private String sources;
    private Date startdate;
    private Date finishingdate;
    private boolean finished;


    public Topic(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getFinishingdate() {
        return finishingdate;
    }

    public void setFinishingdate(Date finishingdate) {
        this.finishingdate = finishingdate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", sources='" + sources + '\'' +
                ", startdate=" + startdate +
                ", finishingdate=" + finishingdate +
                ", finished=" + finished +
                '}';
    }
}
