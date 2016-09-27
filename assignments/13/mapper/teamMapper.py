from abstractMapper import abstractMapper
from domain.team import Team
from domain.project import Project
from projectMapper import ProjectMapper

class TeamMapper(abstractMapper):

    def __init__(self):
        super(TeamMapper, self).__init__()
        self.COLUMNS = 'TeamId, Name, ProjectId'

    def findStatement(self):
        return "SELECT %s FROM Team where TeamId = ? "%self.COLUMNS

    def find(self, domain_id):
        return self.abstractFind(domain_id)

    def doLoad(self, domain_id, rs):
        title = rs[1]
        project_id = rs[2]
        projectMapper = ProjectMapper()
        project = projectMapper.find(project_id)
        return Team(domain_id, title, project_id, project)

