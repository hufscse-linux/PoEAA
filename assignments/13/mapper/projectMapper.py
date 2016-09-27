from abstractMapper import abstractMapper
from domain.project import Project

class ProjectMapper(abstractMapper):

    def __init__(self):
        super(ProjectMapper, self).__init__()
        self.COLUMNS = 'ProjectId, Title'

    def findStatement(self):
        return "SELECT %s FROM Project where ProjectId = ? "%self.COLUMNS

    def find(self, domain_id):
        return self.abstractFind(domain_id)

    def doLoad(self, domain_id, rs):
        title = rs[1]
        return Project(domain_id, title)

